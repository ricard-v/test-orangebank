package com.mackosoft.testorangebank.getjetbrainrepos.domain.usecases

import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity
import com.mackosoft.testorangebank.getjetbrainrepos.domain.repositories.GetJetBrainReposRepository
import com.mackosoft.testorangebank.usecases.UseCase
import javax.inject.Inject

class GetJetBrainReposByPage @Inject constructor(
    private val getJetBrainReposRepository: GetJetBrainReposRepository,
) : UseCase<List<JetBrainRepoEntity>, Param> {

    override suspend fun call(param: Param): Result<List<JetBrainRepoEntity>> =
        getJetBrainReposRepository.getJetBrainRepos(page = param.page)

}

data class Param(val page: Int = 0)