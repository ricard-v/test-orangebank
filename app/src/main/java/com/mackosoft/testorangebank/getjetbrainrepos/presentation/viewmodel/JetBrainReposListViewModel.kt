package com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity
import com.mackosoft.testorangebank.getjetbrainrepos.domain.usecases.GetJetBrainReposByPage
import com.mackosoft.testorangebank.getjetbrainrepos.domain.usecases.Param
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JetBrainReposListViewModel @Inject constructor(
    private val getJetBrainReposByPage: GetJetBrainReposByPage,
) : ViewModel() {

    private companion object {
        const val TAG = "JetBrainReposListVM"
    }

    private val _jetBrainReposListState =
        MutableStateFlow<JetBrainReposListState>(value = JetBrainReposListState.Empty)
    val jetBrainReposListState: StateFlow<JetBrainReposListState>
        get() = _jetBrainReposListState

    fun addEvent(event: JetBrainReposEvent) {
        if (_jetBrainReposListState.value === JetBrainReposListState.Loading) {
            return // already loading, dismissing event
        }

        viewModelScope.launch {
            _jetBrainReposListState.value = JetBrainReposListState.Loading

            getJetBrainReposByPage.call(
                param = Param(page = event.page)
            ).fold(
                onSuccess = { reposList ->
                    _jetBrainReposListState.value = JetBrainReposListState.Success(reposList)
                },
                onFailure = { exception ->
                    Log.e(
                        TAG,
                        "Failed to get JetBrain Repos List:\n${exception.localizedMessage}",
                        exception,
                    )
                    _jetBrainReposListState.value =
                        JetBrainReposListState.Failure(
                            exception.localizedMessage ?: "unknown error"
                        )
                }
            )
        }
    }
}

sealed class JetBrainReposListState {
    object Empty : JetBrainReposListState()
    object Loading : JetBrainReposListState()
    data class Success(val repos: List<JetBrainRepoEntity>) : JetBrainReposListState()
    data class Failure(val errorMessage: String) : JetBrainReposListState()
}

sealed class JetBrainReposEvent(val page: Int) {
    object GetJetBrainRepos : JetBrainReposEvent(page = 0)
    class GetJetBrainReposByPage(page: Int) : JetBrainReposEvent(page = page)
}