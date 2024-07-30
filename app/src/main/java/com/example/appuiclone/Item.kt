package com.example.appuiclone

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// 데이터 클래스 (사실 데이터가 하나밖에 없지만... ㅋㅋㅋ)
@Parcelize
data class Item(val string: String, var like: Int = 40, var isLiked: Boolean = false) : Parcelable