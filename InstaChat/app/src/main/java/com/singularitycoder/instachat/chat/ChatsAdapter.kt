package com.singularitycoder.instachat.chat

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.singularitycoder.instachat.R
import com.singularitycoder.instachat.databinding.ListItemChatBinding

class ChatsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var chatsList = emptyList<Chat>()
    private var callClickListener: (chat: Chat) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ListItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ContactViewHolder).setData(chatsList[position])
    }

    override fun getItemCount(): Int = chatsList.size

    override fun getItemViewType(position: Int): Int = position

    fun setCallClickListener(listener: (chat: Chat) -> Unit) {
        callClickListener = listener
    }

    inner class ContactViewHolder(
        private val itemBinding: ListItemChatBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(chat: Chat) {
            itemBinding.apply {
                tvChatName.text = chat.userName
                ivCall.setOnClickListener {
                    callClickListener.invoke(chat)
                }
                ivImage.load(chat.userImage) {
                    placeholder(R.drawable.ic_placeholder)
                }
            }
        }
    }
}
