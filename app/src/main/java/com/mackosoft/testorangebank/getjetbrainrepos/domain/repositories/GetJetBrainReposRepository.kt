package com.mackosoft.testorangebank.getjetbrainrepos.domain.repositories

import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity

interface GetJetBrainReposRepository {
    suspend fun getJetBrainRepos(page: Int): Result<List<JetBrainRepoEntity>>
}