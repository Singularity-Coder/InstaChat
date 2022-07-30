package com.singularitycoder.instachat.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.singularitycoder.instachat.R
import com.singularitycoder.instachat.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint

// Get list of nearby wifi networks or get nearby socket clients/servers

@AndroidEntryPoint
class ChatFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ChatFragment()
    }

    private lateinit var binding: FragmentChatBinding

    private val chatsList = ArrayList<Chat>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
    }

    private fun FragmentChatBinding.setupUI() {
        rvChats.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ChatsAdapter()
        }
        chatsList.apply {
            add(Chat(0, 0, "Hithesh Vurjana", getString(R.string.dummy_text_1)))
            add(Chat(1, 0, "Ferocious Snail", getString(R.string.dummy_text_1)))
            add(Chat(2, 0, "Sleeping Whale", getString(R.string.dummy_text_1)))
            add(Chat(3, 0, "Bang Bang", getString(R.string.dummy_text_1)))
            add(Chat(4, 0, "Flying Jackass", getString(R.string.dummy_text_1)))
            add(Chat(5, 0, "Gigantic Buffoon", getString(R.string.dummy_text_1)))
        }
        (rvChats.adapter as ChatsAdapter).apply {
            this.chatsList = this@ChatFragment.chatsList
            notifyDataSetChanged()
        }
    }
}