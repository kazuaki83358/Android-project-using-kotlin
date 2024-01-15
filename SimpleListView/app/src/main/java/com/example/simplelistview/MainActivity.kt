package com.example.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapter View: ListView
        val listView: ListView = findViewById(R.id.listView)

        // Data Source: Array of String
        val androidTopics = arrayOf(
            "1. Android Architecture Components",
            "2. Activities and Fragments",
            "3. Views and ViewGroups",
            "4. Layouts and XML UI Design",
            "5. Intents and Intent Filters",
            "6. RecyclerView and Adapter",
            "7. AsyncTask and Background Processing",
            "8. Services and Broadcast Receivers",
            "9. SQLite Database and Room Persistence Library",
            "10. Permissions in Android",
            "11. Networking and HTTP Requests (e.g., Retrofit)",
            "12. JSON Parsing and Serialization",
            "13. Threading and Concurrency",
            "14. Material Design Guidelines",
            "15. SharedPreferences and Data Storage",
            "16. Firebase for Android",
            "17. Push Notifications",
            "18. App Lifecycle and State Management",
            "19. Debugging and Profiling",
            "20. Unit Testing in Android",
            "21. Gradle Build System",
            "22. Dependency Injection (e.g., Dagger)",
            "23. Version Control (e.g., Git)",
            "24. Continuous Integration (CI) for Android",
            "25. App Publishing on Google Play Store"
        )


        // Adapter
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_expandable_list_item_1,
            androidTopics
        )

        // Set the adapter to the ListView
        listView.adapter = arrayAdapter
    }
}
