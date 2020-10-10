package br.com.laudosmama.repository.account

import br.com.laudosmama.database.model.Account

interface AccountRepository {
    suspend fun deleteAccount()
    suspend fun fetchAccountToken(): String
    suspend fun fetchAccount(): Account?
}
