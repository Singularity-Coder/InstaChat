package com.singularitycoder.instachat.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.singularitycoder.instachat.R
import com.singularitycoder.instachat.databinding.FragmentFeedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(feed: Feed) = FeedFragment().apply {
            arguments = Bundle().apply { putParcelable(ARG_PARAM_FEED, feed) }
        }
    }

    private lateinit var binding: FragmentFeedBinding

    private var feed: Feed? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feed = arguments?.getParcelable(ARG_PARAM_FEED)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
    }

    private fun FragmentFeedBinding.setupUI() {
        tvMediaDescription.text = feed?.mediaDescription
    }
}

private const val ARG_PARAM_FEED = "ARG_PARAM_FEED"