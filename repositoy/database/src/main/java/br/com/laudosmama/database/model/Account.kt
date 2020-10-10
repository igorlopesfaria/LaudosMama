package br.com.laudosmama.database.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Account(
    val token: String,
    val userId: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val validated: Boolean,
    val cpf: String,
    val birthday: String,
    val profileImagePath: String
) : Parcelable
