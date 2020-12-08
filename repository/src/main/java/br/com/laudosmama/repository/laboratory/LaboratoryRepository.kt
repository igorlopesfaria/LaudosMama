package br.com.laudosmama.repository.laboratory

import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.remote.model.response.LaboratoryResponse
import kotlinx.coroutines.flow.Flow

interface LaboratoryRepository {
    suspend fun getLaboratories(): Flow<Result<List<LaboratoryResponse>>>
}