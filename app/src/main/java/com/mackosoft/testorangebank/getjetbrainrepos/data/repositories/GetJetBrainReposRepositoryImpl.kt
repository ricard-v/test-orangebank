package com.mackosoft.testorangebank.getjetbrainrepos.data.repositories

import com.mackosoft.testorangebank.exceptions.RemoteException
import com.mackosoft.testorangebank.getjetbrainrepos.data.datasources.GetJetBrainReposRemoteDataSource
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity
import com.mackosoft.testorangebank.getjetbrainrepos.domain.repositories.GetJetBrainReposRepository
import javax.inject.Inject

class GetJetBrainReposRepositoryImpl @Inject constructor(
    private val remoteDataSource: GetJetBrainReposRemoteDataSource
) : GetJetBrainReposRepository {

    override suspend fun getJetBrainRepos(page: Int): Result<List<JetBrainRepoEntity>> {
        return try {
            val data = remoteDataSource.getJetBrainRepos(page = page)
            Result.success(data)
        } catch (re: RemoteException) {
            Result.failure(re)
        }
    }

}