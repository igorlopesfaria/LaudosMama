package br.com.laudosmama.repository.account

import br.com.laudosmama.repository.database.dao.AccountDao
import br.com.laudosmama.database.model.Account

class AccountRepositoryImpl(private val accountDao: AccountDao) :
    AccountRepository {

    override suspend fun deleteAccount() =
        accountDao.deleteAccount()

    override suspend fun fetchAccount(): Account? =
        accountDao.getAccount()

    override suspend fun fetchAccountToken(): String =
        accountDao.getAccountToken()
}
