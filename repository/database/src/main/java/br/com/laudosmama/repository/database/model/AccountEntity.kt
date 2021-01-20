package br.com.laudosmama.repository.database.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccountEntity(
    val token: String,
    val userId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val validated: Boolean,
    val cpf: String,
    val birthday: String,
    val profileImagePath: String
) : Parcelable
