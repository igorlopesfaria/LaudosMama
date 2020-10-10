package br.com.laudosmama.repository.database

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single(named(ENCRYPTED_PREFERENCES)) { provideEncryptedSharedPreferences(get()) }
}

fun provideEncryptedSharedPreferences(context: Context): SharedPreferences {

    val masterKeyAlias = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    return EncryptedSharedPreferences.create(
        context,
        "LaudosMama_EncryptedSharedPreferences",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}

const val ENCRYPTED_PREFERENCES = "ENCRYPTED_PREFERENCES"
