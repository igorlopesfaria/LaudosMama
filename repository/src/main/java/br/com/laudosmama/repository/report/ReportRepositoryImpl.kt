package br.com.laudosmama.repository.report

import br.com.laudosmama.repository.account.AccountRepository
import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.data.fetchRemote
import br.com.laudosmama.repository.laboratory.LaboratoryRepository
import br.com.laudosmama.repository.remote.model.response.LaboratoryItemResponse
import br.com.laudosmama.repository.remote.model.response.ReportItemResponse
import br.com.laudosmama.repository.remote.service.LaboratoryService
import br.com.laudosmama.repository.remote.service.ReportService
import kotlinx.coroutines.flow.Flow

class ReportRepositoryImpl(private val reportService: ReportService, private val accountRepository: AccountRepository) :
    ReportRepository {

    override suspend fun fetchReports(): Flow<Result<List<ReportItemResponse>>> =
        fetchRemote { reportService.fetchReports(accountRepository.getAccountId()) }
}
