package br.com.laudosmama.repository.database.dao

import android.annotation.SuppressLint
import android.content.SharedPreferences
import br.com.laudosmama.database.model.Account

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
    fun saveAccount(account: Account) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, account.firstName)
        editor.putString(KEY_LAST_NAME, account.lastName)
        editor.putLong(KEY_USER_ID, account.userId)
        editor.putString(KEY_EMAIL, account.email)
        editor.putString(KEY_TOKEN, account.token)
        editor.putBoolean(KEY_VALIDATED, account.validated)
        editor.putString(KEY_CPF, account.cpf)
        editor.putString(KEY_BIRTHDAY, account.birthday)
        editor.putString(KEY_PROFILE_IMAGE_PATH, account.profileImagePath)
        editor.commit()
    }

    fun deleteAccount() {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, null)
        editor.putString(KEY_LAST_NAME, null)
        editor.putLong(KEY_USER_ID, NO_USER)
        editor.putString(KEY_EMAIL, null)
        editor.putString(KEY_TOKEN, null)
        editor.putBoolean(KEY_VALIDATED, false)
        editor.putString(KEY_PROFILE_IMAGE_PATH, null)
        editor.putString(KEY_CPF, null)
        editor.putString(KEY_BIRTHDAY, null)
        editor.apply()
    }

    fun getAccount(): Account? {
        val id = getAccountId()
        return if (id > 0) {
            Account(
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

    private fun getAccountId(): Long =
        sharedPreferences.getLong(KEY_USER_ID, NO_USER)

    private fun getAccountFirstName(): String =
        sharedPreferences.getString(KEY_FIRST_NAME, "").toString()

    private fun getAccountLastName(): String =
        sharedPreferences.getString(KEY_LAST_NAME, "").toString()

    private fun getAccountEmail(): String =
        sharedPreferences.getString(KEY_EMAIL, "").toString()

    fun getAccountToken(): String =
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

private const val NO_USER = -1L
