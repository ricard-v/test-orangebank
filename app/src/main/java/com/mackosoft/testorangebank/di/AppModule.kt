package com.mackosoft.testorangebank.di

import com.mackosoft.testorangebank.getjetbrainrepos.data.datasources.GetJetBrainReposRemoteDataSource
import com.mackosoft.testorangebank.getjetbrainrepos.data.datasources.GetJetBrainReposRemoteDataSourceImpl
import com.mackosoft.testorangebank.getjetbrainrepos.data.datasources.JetBrainReposApi
import com.mackosoft.testorangebank.getjetbrainrepos.data.repositories.GetJetBrainReposRepositoryImpl
import com.mackosoft.testorangebank.getjetbrainrepos.domain.repositories.GetJetBrainReposRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideJetBrainReposApi(): JetBrainReposApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/orgs/jetbrains/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JetBrainReposApi::class.java)
    }

    @Provides
    fun provideGetJetBrainReposRepository(
        remoteDataSource: GetJetBrainReposRemoteDataSource,
    ): GetJetBrainReposRepository {
        return GetJetBrainReposRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    fun provideGetJetBrainReposRemoteDataSource(
        api: JetBrainReposApi,
    ): GetJetBrainReposRemoteDataSource {
        return GetJetBrainReposRemoteDataSourceImpl(api = api)
    }
}