package com.singularitycoder.instachat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.singularitycoder.instachat.databinding.FragmentFeedMainBinding

class FeedMainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = FeedMainFragment()
    }

    private lateinit var binding: FragmentFeedMainBinding

    private val feedList = ArrayList<Feed>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFeedMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
    }

    private fun FragmentFeedMainBinding.setupUI() {
        feedList.apply {
            add(Feed(0, "", getString(R.string.dummy_text_1)))
            add(Feed(1, "", getString(R.string.dummy_text_1)))
            add(Feed(2, "", getString(R.string.dummy_text_1)))
            add(Feed(3, "", getString(R.string.dummy_text_1)))
            add(Feed(4, "", getString(R.string.dummy_text_1)))
            add(Feed(5, "", getString(R.string.dummy_text_1)))
        }
        viewpagerFeed.apply {
            adapter = MainViewPagerAdapter(fragmentManager = requireActivity().supportFragmentManager, lifecycle = lifecycle)
            orientation = ViewPager2.ORIENTATION_VERTICAL
//            setPageTransformer(ZoomOutPageTransformer())
            registerOnPageChangeCallback(getOnPageChangeCallback())
        }
    }

    private fun getOnPageChangeCallback(): OnPageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            if (position == feedList.lastIndex) {
                // Last feed. Hide scroll down icon
            } else {
                // Still feeds are left
            }
        }
    }

    inner class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int = feedList.size
        override fun createFragment(position: Int): Fragment = FeedFragment.newInstance(feedList[position])
    }
}