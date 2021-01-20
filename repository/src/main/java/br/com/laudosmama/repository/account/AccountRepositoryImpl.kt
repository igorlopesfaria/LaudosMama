package br.com.laudosmama.repository.account

import br.com.laudosmama.repository.data.Result
import br.com.laudosmama.repository.data.fetchLocal
import br.com.laudosmama.repository.database.dao.AccountDao
import br.com.laudosmama.repository.database.model.AccountEntity
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl(private val accountDao: AccountDao) :
    AccountRepository {

    override suspend fun deleteAccount(): Flow<Result<Unit>> =
        fetchLocal { accountDao.deleteAccount() }

    override suspend fun fetchAccount(): Flow<Result<AccountEntity?>> =
        fetchLocal { accountDao.getAccount() }

    override suspend fun getAccountId(): String =
        accountDao.getAccountId()
}
