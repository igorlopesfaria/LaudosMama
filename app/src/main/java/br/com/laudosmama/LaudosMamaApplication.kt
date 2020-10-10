package br.com.laudosmama

import android.app.Application
import br.com.laudosmama.repository.database.sharedPreferencesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LaudosMamaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@LaudosMamaApplication)
            koin.loadModules(
                listOf(
                    sharedPreferencesModule
                )
            )
            koin.createRootScope()
        }
    }
}