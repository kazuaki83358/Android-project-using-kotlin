package `in`.kazuaki.agora.agora.media

import `in`.kazuaki.agora.R
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import io.agora.rtc2.*

class AudioActivity : AppCompatActivity() {

    private val appId = "5fb926599aeb4ba391c29247cc3b6f71"
    private val appCertificate = "b5065fbfa5ed4d8aba0c25de974502b1"
    private val expirationTimeInSeconds = 3600
    private val channelName = "papayacoders"
    private var token: String? = null
    private val uid = 0
    private var isJoined = false
    private var agoraEngine: RtcEngine? = null

    private val PERMISSION_REQ_ID = 22
    private val REQUESTED_PERMISSIONS = arrayOf(
        Manifest.permission.RECORD_AUDIO
    )

    private lateinit var btnStartAudioCall: Button
    private lateinit var btnEndAudioCall: Button

    private fun checkSelfPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, REQUESTED_PERMISSIONS[0]) == PackageManager.PERMISSION_GRANTED
    }

    fun showMessage(message: String?) {
        runOnUiThread {
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAudioSDKEngine() {
        try {
            val config = RtcEngineConfig()
            config.mContext = baseContext
            config.mAppId = appId
            config.mEventHandler = mRtcEventHandler
            agoraEngine = RtcEngine.create(config)
        } catch (e: Exception) {
            showMessage(e.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        btnStartAudioCall = findViewById(R.id.btn_start_audio_call)
        btnEndAudioCall = findViewById(R.id.btn_end_audio_call)

        val tokenBuilder = RtcTokenBuilder2()
        val timestamp = (System.currentTimeMillis() / 1000 + expirationTimeInSeconds).toInt()

        token = tokenBuilder.buildTokenWithUid(
            appId, appCertificate,
            channelName, uid, RtcTokenBuilder2.Role.ROLE_PUBLISHER, timestamp, timestamp
        )

        if (!checkSelfPermission()) {
            ActivityCompat.requestPermissions(this, REQUESTED_PERMISSIONS, PERMISSION_REQ_ID)
        }
        setupAudioSDKEngine()

        btnStartAudioCall.setOnClickListener {
            joinChannel()
        }

        btnEndAudioCall.setOnClickListener {
            leaveChannel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        agoraEngine?.leaveChannel()
        RtcEngine.destroy()
        agoraEngine = null
    }

    private val mRtcEventHandler: IRtcEngineEventHandler = object : IRtcEngineEventHandler() {
        override fun onJoinChannelSuccess(channel: String, uid: Int, elapsed: Int) {
            isJoined = true
            showMessage("Joined Channel $channel")
            runOnUiThread {
                btnStartAudioCall.visibility = View.GONE
                btnEndAudioCall.visibility = View.VISIBLE
            }
        }

        override fun onUserOffline(uid: Int, reason: Int) {
            showMessage("Remote user offline $uid $reason")
        }

        override fun onLeaveChannel(stats: IRtcEngineEventHandler.RtcStats?) {
            runOnUiThread {
                btnStartAudioCall.visibility = View.VISIBLE
                btnEndAudioCall.visibility = View.GONE
            }
        }
    }

    private fun joinChannel() {
        if (checkSelfPermission()) {
            val options = ChannelMediaOptions()
            options.channelProfile = Constants.CHANNEL_PROFILE_COMMUNICATION
            options.clientRoleType = Constants.CLIENT_ROLE_BROADCASTER

            agoraEngine?.joinChannel(token, channelName, uid, options)
        } else {
            showMessage("Permissions was not granted")
        }
    }

    private fun leaveChannel() {
        if (!isJoined) {
            showMessage("Join a channel first")
        } else {
            agoraEngine?.leaveChannel()
            showMessage("You left the channel")
            isJoined = false
        }
    }
}
