package br.com.laudosmama

import android.app.Application
import br.com.laudosmama.modules.serviceModule
import br.com.laudosmama.repository.database.sharedPreferencesModule
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LaudosMamaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        startKoin {
            androidLogger()
            androidContext(this@LaudosMamaApplication)
            koin.loadModules(
                listOf(
                    sharedPreferencesModule,
                    serviceModule
                )
            )
            koin.createRootScope()
        }
    }
}