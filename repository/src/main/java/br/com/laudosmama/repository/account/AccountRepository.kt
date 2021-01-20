package br.com.laudosmama.repository.account

import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.database.model.AccountEntity
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    suspend fun deleteAccount(): Flow<Result<Unit>>
    suspend fun getAccountId(): String
    suspend fun fetchAccount(): Flow<Result<AccountEntity?>>
}
