package br.com.laudosmama.repository.laboratory

import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.data.fetchRemote
import br.com.laudosmama.repository.remote.model.response.LaboratoryItemResponse
import br.com.laudosmama.repository.remote.service.LaboratoryService
import kotlinx.coroutines.flow.Flow

class LaboratoryRepositoryImpl(private val laboratoryService: LaboratoryService) :
    LaboratoryRepository {

    override suspend fun fetchLaboratories(): Flow<Result<List<LaboratoryItemResponse>>> =
        fetchRemote { laboratoryService.fetchLaboratories() }
}
