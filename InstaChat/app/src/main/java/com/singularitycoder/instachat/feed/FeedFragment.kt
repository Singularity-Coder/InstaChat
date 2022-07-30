package com.singularitycoder.instachat.feed

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
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
    private lateinit var exoPlayer: ExoPlayer

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
        setupExoPlayer()
    }

    private fun FragmentFeedBinding.setupUI() {
        tvMediaDescription.text = feed?.mediaDescription
        videoView.setOnClickListener {
            if (exoPlayer.isPlaying) {
                exoPlayer.pause()
            } else {
                exoPlayer.play()
            }
        }
    }

    // https://stackoverflow.com/questions/44217063/exoplayer-not-looping-the-video
    // https://stackoverflow.com/questions/48988063/how-can-i-scale-video-in-exoplayer-v2-play-video-in-full-screen
    // https://stackoverflow.com/questions/42263371/how-to-hide-control-buttons-in-exoplayer2
    private fun setupExoPlayer() {
        val mediaItem = MediaItem.fromUri(Uri.parse(feed?.mediaPath))
        exoPlayer = ExoPlayer.Builder(requireContext()).build().apply {
            binding.videoView.player = this
            addMediaItem(mediaItem)
            repeatMode = Player.REPEAT_MODE_ONE // Loop video
            prepare()
            play()
        }
    }
}

private const val ARG_PARAM_FEED = "ARG_PARAM_FEED"