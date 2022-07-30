package com.singularitycoder.instachat.chat

import androidx.annotation.DrawableRes

data class Chat(
    val id: Long,
    @DrawableRes val userImage: Int,
    val userName: String,
    val latestChat: String,
)
