package com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mackosoft.testorangebank.R
import com.mackosoft.testorangebank.databinding.JetBrainRepoItemViewBinding
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity

class JetBrainRepoItemView(
    private val binding: JetBrainRepoItemViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: JetBrainRepoEntity) {
        binding.fullName.text = item.fullName
        binding.description.text = item.description

        binding.forksCount.text = itemView.resources.getString(R.string.forks_count, item.forks)
        binding.openIssuesCount.text = itemView.resources.getString(
            R.string.open_issues_count,
            item.forks,
        )
        binding.watchersCount.text = itemView.resources.getString(
            R.string.watchers_count,
            item.forks,
        )
    }

    fun onRecycled() {
        binding.fullName.text = null
        binding.description.text = null
        binding.forksCount.text = null
        binding.openIssuesCount.text = null
        binding.watchersCount.text = null
    }
}