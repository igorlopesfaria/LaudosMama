package br.com.laudosmama.onboarding.splash.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import br.com.laudosmama.features.base.BaseViewModel
import br.com.laudosmama.onboarding.splash.model.SplashAccount
import br.com.laudosmama.onboarding.splash.state.SplashUiState
import br.com.laudosmama.repository.account.AccountRepository
import br.com.laudosmama.repository.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashViewModel(private val accountRepository: AccountRepository) : BaseViewModel(){

    private val _state = MutableStateFlow<SplashUiState>(SplashUiState.Start)
    val state: StateFlow<SplashUiState> get() = _state

    fun loadAccountCredentials() {
        viewModelScope.launch(Dispatchers.IO) {
            sleep(3000)
            accountRepository.fetchAccount().collect { resultAccount ->
                when (resultAccount) {
                    is Result.Success ->
                        if(resultAccount.data != null)
                            _state.value = SplashUiState.Success(SplashAccount(resultAccount.data!!))
                        else
                            _state.value = SplashUiState.Empty

                    is Result.Failure ->
                        _state.value = SplashUiState.Loading
                    is Result.Loading ->
                        _state.value = SplashUiState.Loading
                    else -> Unit
                }
            }
        }
    }
}

