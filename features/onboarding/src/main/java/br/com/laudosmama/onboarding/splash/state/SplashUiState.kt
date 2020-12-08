package br.com.laudosmama.onboarding.splash.state

import br.com.laudosmama.onboarding.splash.model.SplashAccount

sealed class SplashUiState {
    object Start : SplashUiState()
    object Loading : SplashUiState()
    object Empty: SplashUiState()
    data class Success(val splashAccount: SplashAccount): SplashUiState()
    object DatabaseError: SplashUiState()
}
