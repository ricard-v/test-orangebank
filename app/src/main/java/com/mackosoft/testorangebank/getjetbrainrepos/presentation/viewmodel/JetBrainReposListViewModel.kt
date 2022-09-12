package com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity
import com.mackosoft.testorangebank.getjetbrainrepos.domain.usecases.GetJetBrainReposByPage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class JetBrainReposListViewModel @Inject constructor(
    private val getJetBrainReposByPage: GetJetBrainReposByPage,
) : ViewModel() {

    private val _jetBrainReposListState =
        MutableStateFlow<JetBrainReposListState>(value = JetBrainReposListState.Empty)
    val jetBrainReposListState: StateFlow<JetBrainReposListState>
        get() = _jetBrainReposListState

    fun addEvent(event: JetBrainReposEvent) {
        // TODO handle event
    }
}

sealed class JetBrainReposListState {
    object Empty : JetBrainReposListState()
    object Loading : JetBrainReposListState()
    data class Success(val repos: List<JetBrainRepoEntity>) : JetBrainReposListState()
    data class Failure(val errorMessage: String) : JetBrainReposListState()
}

sealed class JetBrainReposEvent(page: Int) {
    object GetJetBrainRepos : JetBrainReposEvent(page = 0)
    data class GetJetBrainReposByPage(val page: Int) : JetBrainReposEvent(page = page)
}