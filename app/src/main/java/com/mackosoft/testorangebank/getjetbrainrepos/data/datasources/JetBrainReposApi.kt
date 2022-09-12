package com.mackosoft.testorangebank.getjetbrainrepos.data.datasources

import com.mackosoft.testorangebank.getjetbrainrepos.data.models.JetBrainRepoModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JetBrainReposApi {
    @GET("repos")
    suspend fun getJetBrainReposPage(@Query("page_number") page: Int): List<JetBrainRepoModel>
}