package br.com.laudosmama.laboratory.list.model

import android.os.Parcelable
import br.com.laudosmama.repository.remote.model.response.LaboratoryResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
class LaboratoryItem(
    val name: String,
    val address: String,
    val email: String,
    val telephoneNumber: String,
    val logoImage: String
) : Parcelable {
    constructor(laboratoryResponse: LaboratoryResponse) : this(
        name = laboratoryResponse.name,
        email = laboratoryResponse.email,
        address = laboratoryResponse.address,
        telephoneNumber = laboratoryResponse.phone,
        logoImage = laboratoryResponse.logoImage
    )
}