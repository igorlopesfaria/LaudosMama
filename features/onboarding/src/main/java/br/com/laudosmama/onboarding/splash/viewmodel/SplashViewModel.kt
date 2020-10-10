package br.com.laudosmama.onboarding.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.laudosmama.features.base.BaseViewModel
import br.com.laudosmama.features.livedata.SingleLiveEvent
import br.com.laudosmama.onboarding.splash.model.SplashAccount
import br.com.laudosmama.repository.account.AccountRepository
import br.com.laudosmama.repository.data.Error
import br.com.laudosmama.repository.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashViewModel(private val accountRepository: AccountRepository) : BaseViewModel(){

    private val _accountLiveData = SingleLiveEvent<Result<SplashAccount>>()
    val accountLiveData: LiveData<Result<SplashAccount>>
        get() = _accountLiveData

    fun loadAccountCredentials() {
        viewModelScope.launch(Dispatchers.IO) {
            _accountLiveData.postValue(Result.Loading)
            sleep(3000)

            accountRepository.fetchAccount()?.let {
                _accountLiveData.postValue(Result.Success(SplashAccount(it)))
            } ?: run {
                _accountLiveData.postValue(Result.Failure(Error.ItemNotFound))
            }
        }
    }
}