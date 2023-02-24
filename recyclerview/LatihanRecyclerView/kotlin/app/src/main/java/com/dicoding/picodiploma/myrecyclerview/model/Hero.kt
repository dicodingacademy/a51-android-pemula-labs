package com.dicoding.picodiploma.myrecyclerview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by sidiqpermana on 10/29/16.
 */

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
