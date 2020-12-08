package br.com.laudosmama.repository.remote.model.response

import com.google.gson.annotations.SerializedName

data class LaboratoryResponse (
    @SerializedName(value = "id")
    val id: String,

    @SerializedName(value = "name")
    val name: String,

    @SerializedName(value = "address")
    val address: String,

    @SerializedName(value = "phone")
    val phone: String,

    @SerializedName(value = "whatsapp")
    val whatsapp: String,

    @SerializedName(value = "email")
    val email: String,

    @SerializedName(value = "lat")
    val lat: Double,

    @SerializedName(value = "long")
    val long: Double,

    @SerializedName(value = "logoImage")
    val logoImage: String
)
