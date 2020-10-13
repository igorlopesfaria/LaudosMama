package br.com.laudosmama.reports.register.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ReportItem(
    val id: Long = 1,
    val examDate: String = "",
    val rightBreast: String = "",
    val leftBreast: String = "",
    val medicalReportPath: String = "",
    val professionalEmail: String = "",
    val shouldIndicateLab: Boolean = false
) : Parcelable {
}