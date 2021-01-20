package br.com.laudosmama.repository.database.dao

import android.annotation.SuppressLint
import android.content.SharedPreferences
import br.com.laudosmama.repository.database.model.AccountEntity

class AccountDao(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val KEY_FIRST_NAME = "first_name"
        private const val KEY_LAST_NAME = "last_name"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_EMAIL = "email"
        private const val KEY_TOKEN = "token"
        private const val KEY_VALIDATED = "token"
        private const val KEY_CPF = "cpf"
        private const val KEY_BIRTHDAY = "birthday"
        private const val KEY_PROFILE_IMAGE_PATH = "profile_image_path"
    }

    @SuppressLint("ApplySharedPref")
    fun saveAccount(accountEntity: AccountEntity) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, accountEntity.firstName)
        editor.putString(KEY_LAST_NAME, accountEntity.lastName)
        editor.putString(KEY_USER_ID, accountEntity.userId)
        editor.putString(KEY_EMAIL, accountEntity.email)
        editor.putString(KEY_TOKEN, accountEntity.token)
        editor.putBoolean(KEY_VALIDATED, accountEntity.validated)
        editor.putString(KEY_CPF, accountEntity.cpf)
        editor.putString(KEY_BIRTHDAY, accountEntity.birthday)
        editor.putString(KEY_PROFILE_IMAGE_PATH, accountEntity.profileImagePath)
        editor.commit()
    }

    fun deleteAccount() {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, null)
        editor.putString(KEY_LAST_NAME, null)
        editor.putString(KEY_USER_ID, NO_USER)
        editor.putString(KEY_EMAIL, null)
        editor.putString(KEY_TOKEN, null)
        editor.putBoolean(KEY_VALIDATED, false)
        editor.putString(KEY_PROFILE_IMAGE_PATH, null)
        editor.putString(KEY_CPF, null)
        editor.putString(KEY_BIRTHDAY, null)
        editor.apply()
    }

    fun getAccount(): AccountEntity? {
        val id = getAccountId()
        return if (id.toLong() > 0) {
            AccountEntity(
                userId = id,
                firstName = getAccountFirstName(),
                lastName = getAccountLastName(),
                email = getAccountEmail(),
                token = getAccountToken(),
                validated = isValidated(),
                cpf = getCPF(),
                birthday = getBirthday(),
                profileImagePath = getProfilePath()
            )
        } else null
    }

    fun getAccountId(): String =
        sharedPreferences.getString(KEY_USER_ID, NO_USER).toString()

    private fun getAccountFirstName(): String =
        sharedPreferences.getString(KEY_FIRST_NAME, "").toString()

    private fun getAccountLastName(): String =
        sharedPreferences.getString(KEY_LAST_NAME, "").toString()

    private fun getAccountEmail(): String =
        sharedPreferences.getString(KEY_EMAIL, "").toString()

    private fun getAccountToken(): String =
        sharedPreferences.getString(KEY_TOKEN, "").toString()

    private fun isValidated(): Boolean =
        sharedPreferences.getBoolean(KEY_VALIDATED, false)

    private fun getCPF(): String =
        sharedPreferences.getString(KEY_CPF, "").toString()

    private fun getBirthday(): String =
        sharedPreferences.getString(KEY_BIRTHDAY, "").toString()

    private fun getProfilePath(): String =
        sharedPreferences.getString(KEY_PROFILE_IMAGE_PATH, "").toString()

}

private const val NO_USER = "-1"
