package br.com.laudosmama.laboratory.list.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class LaboratoryItem(
    val id: Long = 1,
    val name: String = "",
    val distance: String = "",
    val telephoneNumber: String = ""
    ) : Parcelable {
}