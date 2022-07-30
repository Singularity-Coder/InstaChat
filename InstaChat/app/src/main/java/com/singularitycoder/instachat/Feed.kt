package com.singularitycoder.instachat

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feed(
    val id: Long,
    val mediaPath: String,
    val mediaDescription: String
) : Parcelable
