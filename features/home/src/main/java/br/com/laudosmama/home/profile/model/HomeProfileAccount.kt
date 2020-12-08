package br.com.laudosmama.home.profile.model

import android.os.Parcelable
import br.com.laudosmama.repository.database.model.AccountEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class HomeProfileAccount(
    private val firstName: String,
    private val lastName: String,
    val cpf: String,
    val birthday: String,
    val profileImagePath: String
) : Parcelable {
    constructor(account: AccountEntity) : this(
        firstName = account.firstName,
        lastName = account.lastName,
        cpf = account.cpf,
        birthday = account.birthday,
        profileImagePath = account.profileImagePath
    )
}