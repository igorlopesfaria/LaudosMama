package br.com.laudosmama.onboarding.splash.model

import android.os.Parcelable
import br.com.laudosmama.database.model.Account
import kotlinx.android.parcel.Parcelize

@Parcelize
class SplashAccount(
    val token: String?,
    val validated: Boolean
) : Parcelable {
    constructor(account: Account) : this(
        token = account.token,
        validated = account.validated
    )
}