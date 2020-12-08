package br.com.laudosmama.modules

import okhttp3.EventListener
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val serviceModule = module {
    single(named(DEFAULT)) { provideRetrofit(get(named(DEFAULT_OKHTTP))) }
    single(named(DEFAULT_OKHTTP)) { provideDefaultOkHttpClient() }

}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://breast-reporter.herokuapp.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideDefaultOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .retryOnConnectionFailure(false)
        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
    return builder.build()
}
private const val DEFAULT_TIMEOUT: Long = 10
const val DEFAULT = "default"
const val DEFAULT_OKHTTP = "default_okhttp"
