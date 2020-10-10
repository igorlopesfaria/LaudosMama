package br.com.laudosmama.onboarding

import android.content.SharedPreferences
import br.com.laudosmama.onboarding.login.viewmodel.LoginViewModel
import br.com.laudosmama.onboarding.register.viewmodel.RegisterViewModel
import br.com.laudosmama.onboarding.resetpassword.viewmodel.ResetPasswordViewModel
import br.com.laudosmama.onboarding.splash.viewmodel.SplashViewModel
import br.com.laudosmama.repository.account.AccountRepository
import br.com.laudosmama.repository.account.AccountRepositoryImpl
import br.com.laudosmama.repository.database.ENCRYPTED_PREFERENCES
import br.com.laudosmama.repository.database.dao.AccountDao
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val onboardingModule = module {
    single { provideAccountDao(get(named(ENCRYPTED_PREFERENCES))) }
    single { provideAccountRepository(get()) }
    viewModel { provideSplashViewModel(get()) }
    viewModel { provideLoginViewModel() }
    viewModel { provideResetPasswordViewModel() }
    viewModel { provideRegisterViewModel() }
}

fun provideSplashViewModel(accountRepository: AccountRepository): SplashViewModel {
    return SplashViewModel(accountRepository)
}

fun provideLoginViewModel(): LoginViewModel {
    return LoginViewModel()
}

fun provideResetPasswordViewModel(): ResetPasswordViewModel {
    return ResetPasswordViewModel()
}

fun provideRegisterViewModel(): RegisterViewModel {
    return RegisterViewModel()
}

fun provideAccountRepository(dao: AccountDao): AccountRepository {
    return AccountRepositoryImpl(dao)
}

fun provideAccountDao(sharedPreferences: SharedPreferences): AccountDao {
    return AccountDao(
        sharedPreferences
    )
}
