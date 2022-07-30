package com.singularitycoder.instachat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.singularitycoder.instachat.chat.ChatFragment
import com.singularitycoder.instachat.databinding.ActivityMainBinding
import com.singularitycoder.instachat.feed.FeedMainFragment
import dagger.hilt.android.AndroidEntryPoint

// View pager main horizontal
// View Pager feed vertical

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.viewpagerMain.adapter = MainViewPagerAdapter(fragmentManager = supportFragmentManager, lifecycle = lifecycle)
    }

    inner class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int = 2
        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> ChatFragment.newInstance()
            else -> FeedMainFragment.newInstance()
        }
    }
}