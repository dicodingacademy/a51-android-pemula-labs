package com.dicoding.picodiploma.myintentapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by sidiqpermana on 9/11/16.
 */
@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable

/*
jika tanpa menggunakan parcelize
*/

//{
//    constructor(parcel: Parcel) : this(
//            parcel.readString(),
//            parcel.readValue(Int::class.java.classLoader) as? Int,
//            parcel.readString(),
//            parcel.readString()) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeValue(age)
//        parcel.writeString(email)
//        parcel.writeString(city)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Person> {
//        override fun createFromParcel(parcel: Parcel): Person {
//            return Person(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Person?> {
//            return arrayOfNulls(size)
//        }
//    }
//}