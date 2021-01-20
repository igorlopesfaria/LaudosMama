package br.com.laudosmama.repository.report

import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.remote.model.response.LaboratoryItemResponse
import br.com.laudosmama.repository.remote.model.response.ReportItemResponse
import kotlinx.coroutines.flow.Flow

interface ReportRepository {
    suspend fun fetchReports(): Flow<Result<List<ReportItemResponse>>>
}