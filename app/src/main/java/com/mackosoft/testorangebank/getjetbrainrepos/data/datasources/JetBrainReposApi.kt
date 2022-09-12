package com.mackosoft.testorangebank.getjetbrainrepos.data.datasources

import com.mackosoft.testorangebank.getjetbrainrepos.data.models.JetBrainRepoModel
import retrofit2.http.GET
import retrofit2.http.Path

interface JetBrainReposApi {
    @GET("repos?page={page_number}")
    suspend fun getJetBrainReposPage(@Path("page_number") page: Int): List<JetBrainRepoModel>
}