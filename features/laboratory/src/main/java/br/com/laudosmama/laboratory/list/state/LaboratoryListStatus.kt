package br.com.laudosmama.laboratory.list.state

import br.com.laudosmama.laboratory.list.model.LaboratoryItem

sealed class LaboratoryListUiState() {
    object Start : LaboratoryListUiState()
    object Loading : LaboratoryListUiState()
    object Empty: LaboratoryListUiState()
    data class Success(val listLaboratoryItem: List<LaboratoryItem>): LaboratoryListUiState()
    object ServerError: LaboratoryListUiState()
}
