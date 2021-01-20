package br.com.laudosmama.repository.remote.model.response

import com.google.gson.annotations.SerializedName

data class ReportItemResponse (
    @SerializedName(value = "id")
    val id: String,

    @SerializedName(value = "breastLeft")
    val breastLeft: String,

    @SerializedName(value = "breastRight")
    val breastRight: String,

    @SerializedName(value = "createdAt")
    val createdAt: String,

    @SerializedName(value = "examedAt")
    val examinedAt: String,

    @SerializedName(value = "generalComments")
    val generalComments: String,

    @SerializedName(value = "medicalEmail")
    val medicalEmail: String,

    @SerializedName(value = "report")
    val reportImage: String,

    @SerializedName(value = "reportedAt")
    val reportedAt: String,

    @SerializedName(value = "shouldShowLab")
    val shouldShowLab: Boolean

)
