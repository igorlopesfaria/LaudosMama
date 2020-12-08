package br.com.laudosmama.home.timeline.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HomeTimeline(
    val id: Long = 1,
    val examDate: String = "",
    val rightBreast: String = "",
    val leftBreast: String = "",
    val medicalReportPath: String = "",
    val shouldIndicateLab: Boolean = false
    ) : Parcelable {
}