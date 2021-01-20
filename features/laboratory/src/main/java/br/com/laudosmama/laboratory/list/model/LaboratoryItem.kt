package br.com.laudosmama.laboratory.list.model

import android.os.Parcelable
import br.com.laudosmama.repository.remote.model.response.LaboratoryItemResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
class LaboratoryItem(
    val name: String,
    val address: String,
    val email: String,
    val telephoneNumber: String,
    val logoImage: String
) : Parcelable {
    constructor(laboratoryItemResponse: LaboratoryItemResponse) : this(
        name = laboratoryItemResponse.name,
        email = laboratoryItemResponse.email,
        address = laboratoryItemResponse.address,
        telephoneNumber = laboratoryItemResponse.phone,
        logoImage = laboratoryItemResponse.logoImage
    )
}