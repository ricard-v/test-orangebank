package com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mackosoft.testorangebank.R
import com.mackosoft.testorangebank.databinding.FragmentJetBrainReposListBinding
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui.adapter.JetBrainReposListAdapter
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui.adapter.JetBrainReposListDecoration
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel.JetBrainReposEvent
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel.JetBrainReposListState
import com.mackosoft.testorangebank.getjetbrainrepos.presentation.viewmodel.JetBrainReposListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JetBrainReposListFragment: Fragment(R.layout.fragment_jet_brain_repos_list) {

    private lateinit var binding: FragmentJetBrainReposListBinding
    private val viewModel: JetBrainReposListViewModel by viewModels()

    private val adapter = JetBrainReposListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi(view)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.jetBrainReposListState.collect(::handleState)
        }
    }

    private fun setupUi(view: View) {
        binding = FragmentJetBrainReposListBinding.bind(view)

        binding.root.setOnRefreshListener {
            getJetBrainRepos()
        }
        binding.jetBrainReposList.apply {
            setHasFixedSize(true)
            adapter = this@JetBrainReposListFragment.adapter
            addItemDecoration(JetBrainReposListDecoration(requireContext()))
        }
    }

    override fun onResume() {
        super.onResume()
        getJetBrainRepos()
    }

    private fun getJetBrainRepos(page: Int? = null) {
        page?.let {
            viewModel.addEvent(JetBrainReposEvent.GetJetBrainReposByPage(page))
        } ?: run {
            viewModel.addEvent(JetBrainReposEvent.GetJetBrainRepos)
        }
    }

    private fun handleState(state: JetBrainReposListState) {
        val context = context ?: return

        when (state) {
            JetBrainReposListState.Empty -> {
                binding.root.isRefreshing = false
                adapter.submitList(emptyList())
            }
            is JetBrainReposListState.Failure -> {
                binding.root.isRefreshing = false
                adapter.submitList(emptyList())
                Toast.makeText(context, state.errorMessage, Toast.LENGTH_LONG).show()
            }
            JetBrainReposListState.Loading -> {
                binding.root.isRefreshing = true
            }
            is JetBrainReposListState.Success -> {
                binding.root.isRefreshing = false
                adapter.submitList(state.repos)
            }
        }
    }
}