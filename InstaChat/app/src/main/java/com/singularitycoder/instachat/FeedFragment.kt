package com.singularitycoder.instachat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.singularitycoder.instachat.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
    }

    private fun FragmentFeedBinding.setupUI() {
        layoutBack.ibIcon.setImageResource(R.drawable.ic_round_arrow_back_24)
        layoutAddMedia.ibIcon.setImageResource(R.drawable.ic_round_play_arrow_24)
        layoutLike.ibIcon.setImageResource(R.drawable.ic_round_favorite_border_24)
        layoutAddMedia.ibIcon.setImageResource(R.drawable.ic_round_add_24)
    }
}