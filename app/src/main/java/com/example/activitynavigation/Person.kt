package com.example.activitynavigation
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (val firstName: String = "Elon",
              val lastName: String = "Mask",
              val age: Int = 50): Parcelable