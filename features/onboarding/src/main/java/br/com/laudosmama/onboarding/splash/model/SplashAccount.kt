package br.com.laudosmama.onboarding.splash.model

import android.os.Parcelable
import br.com.laudosmama.repository.database.model.AccountEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class SplashAccount(
    val token: String?,
    val validated: Boolean
) : Parcelable {
    constructor(account: AccountEntity) : this(
        token = account.token,
        validated = account.validated
    )
}