package com.mackosoft.testorangebank.getjetbrainrepos.data.datasources

import com.mackosoft.testorangebank.exceptions.RemoteException
import com.mackosoft.testorangebank.getjetbrainrepos.data.models.JetBrainRepoModel
import javax.inject.Inject

interface GetJetBrainReposRemoteDataSource {
    /**
     * @throws [RemoteException]
     */
    suspend fun getJetBrainRepos(page: Int = 0): List<JetBrainRepoModel>
}

class GetJetBrainReposRemoteDataSourceImpl @Inject constructor(
    private val api: JetBrainReposApi,
) : GetJetBrainReposRemoteDataSource {

    override suspend fun getJetBrainRepos(page: Int): List<JetBrainRepoModel> {
        try {
            return api.getJetBrainReposPage(page = page)
        } catch (e: Exception) {
            throw RemoteException(errorMessage = e.localizedMessage ?: "unknown error")
        }
    }

}