package com.example.tablayoutapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutapp.fragments.BookFragment
import com.example.tablayoutapp.fragments.GameFragment
import com.example.tablayoutapp.fragments.MovieFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        // Return a different fragment instance based on position
        // For example, assuming you have three different fragment classes:
        return when (position) {
            0 -> GameFragment()
            1 -> BookFragment()
            else -> MovieFragment()
        }
    }
}
