package com.example.harrypotterfans

import android.os.Parcel
import android.os.Parcelable

data class PostModel (
    val id: String? ="",
    val name: String? = "",
    val alternateNames: String?="",
    val species: String? = "",
    val dateOfBirth: String? = "",
    val gender: String? = "",
    val house: String? = "",
    val ancestry: String? = "",
    val hogwartsStudent: Boolean? = false,
    val eyeColor: String? = "",
    val hairColor: String? = "",
    val actor: String? = "",
    val hogwartsStaff: Boolean? = false,
    val alive: Boolean? = true,
    val image: String? = "",
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(alternateNames)
        parcel.writeString(species)
        parcel.writeString(dateOfBirth)
        parcel.writeString(gender)
        parcel.writeString(house)
        parcel.writeString(ancestry)
        parcel.writeValue(hogwartsStudent)
        parcel.writeString(eyeColor)
        parcel.writeString(hairColor)
        parcel.writeString(actor)
        parcel.writeValue(hogwartsStaff)
        parcel.writeValue(alive)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostModel> {
        override fun createFromParcel(parcel: Parcel): PostModel {
            return PostModel(parcel)
        }

        override fun newArray(size: Int): Array<PostModel?> {
            return arrayOfNulls(size)
        }
    }
}