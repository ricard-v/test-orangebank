package com.mackosoft.testorangebank.getjetbrainrepos.data.repositories

import com.mackosoft.testorangebank.exceptions.RemoteException
import com.mackosoft.testorangebank.getjetbrainrepos.data.datasources.GetJetBrainReposRemoteDataSource
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity
import com.mackosoft.testorangebank.getjetbrainrepos.domain.repositories.GetJetBrainReposRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetJetBrainReposRepositoryImpl @Inject constructor(
    private val remoteDataSource: GetJetBrainReposRemoteDataSource
) : GetJetBrainReposRepository {

    override suspend fun getJetBrainRepos(page: Int): Result<List<JetBrainRepoEntity>> {
        return try {
            val data = remoteDataSource.getJetBrainRepos(page = page)
            Result.success(
                withContext(Dispatchers.Default) {
                    data.map { repo ->
                        JetBrainRepoEntity(
                            repo.id,
                            repo.fullName,
                            repo.description,
                            repo.forks ?: 0,
                            repo.openIssues ?: 0,
                            repo.watchers ?: 0,
                        )
                    }
                }
            )
        } catch (re: RemoteException) {
            Result.failure(re)
        }
    }

}