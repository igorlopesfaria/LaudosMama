package br.com.laudosmama.home.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.laudosmama.features.base.BaseViewModel
import br.com.laudosmama.features.livedata.SingleLiveEvent
import br.com.laudosmama.home.profile.model.HomeProfileAccount
import br.com.laudosmama.repository.account.AccountRepository
import br.com.laudosmama.repository.data.Error
import br.com.laudosmama.repository.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeProfileViewModel(private val accountRepository: AccountRepository) : BaseViewModel(){

    private val _accountLiveData = SingleLiveEvent<Result<HomeProfileAccount>>()
    val accountLiveData: LiveData<Result<HomeProfileAccount>>
        get() = _accountLiveData

    fun loadAccountCredentials() {
        viewModelScope.launch(Dispatchers.IO) {
            _accountLiveData.postValue(Result.Loading)
            accountRepository.fetchAccount()?.let {
                _accountLiveData.postValue(Result.Success(HomeProfileAccount(it)))
            } ?: run {
                _accountLiveData.postValue(Result.Failure(Error.ItemNotFound))
            }
        }
    }
}