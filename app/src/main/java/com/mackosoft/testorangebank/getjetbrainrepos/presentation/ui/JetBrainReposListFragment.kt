package com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mackosoft.testorangebank.R
import com.mackosoft.testorangebank.databinding.FragmentJetBrainReposListBinding
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel.JetBrainReposListState
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel.JetBrainReposListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JetBrainReposListFragment: Fragment(R.layout.fragment_jet_brain_repos_list) {

    private lateinit var binding: FragmentJetBrainReposListBinding
    private val viewModel: JetBrainReposListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentJetBrainReposListBinding.bind(view)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.jetBrainReposListState.collect(::handleState)
        }
    }

    private fun handleState(state: JetBrainReposListState) {
        when (state) {
            JetBrainReposListState.Empty -> TODO()
            is JetBrainReposListState.Failure -> TODO()
            JetBrainReposListState.Loading -> TODO()
            is JetBrainReposListState.Success -> TODO()
        }
    }
}