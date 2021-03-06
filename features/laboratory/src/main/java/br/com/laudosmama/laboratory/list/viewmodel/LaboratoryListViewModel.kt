package br.com.laudosmama.laboratory.list.viewmodel

import androidx.lifecycle.viewModelScope
import br.com.laudosmama.features.base.BaseViewModel
import br.com.laudosmama.laboratory.list.model.LaboratoryItem
import br.com.laudosmama.laboratory.list.state.LaboratoryListUiState
import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.laboratory.LaboratoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LaboratoryListViewModel(private val laboratoryRepository: LaboratoryRepository) :
    BaseViewModel() {

    private val _stateListLaboratory =
        MutableStateFlow<LaboratoryListUiState>(LaboratoryListUiState.Start)
    val stateListLaboratory: StateFlow<LaboratoryListUiState> get() = _stateListLaboratory

    fun listLaboratories() {
        viewModelScope.launch(Dispatchers.IO) {
            laboratoryRepository.fetchLaboratories().collect { resultRepository ->
                when (resultRepository) {
                    is Result.Success ->
                        if (resultRepository.data.isNotEmpty())
                            _stateListLaboratory.value = LaboratoryListUiState.Success(
                                resultRepository.data.map { LaboratoryItem(it) }
                            )
                        else _stateListLaboratory.value = LaboratoryListUiState.Empty
                    is Result.Failure ->
                        _stateListLaboratory.value = LaboratoryListUiState.ServerError
                    is Result.Loading ->
                        _stateListLaboratory.value = LaboratoryListUiState.Loading
                }
            }
        }
    }
}