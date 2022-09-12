package com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mackosoft.testorangebank.databinding.JetBrainRepoItemViewBinding
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity

class JetBrainReposListAdapter :
    ListAdapter<JetBrainRepoEntity, JetBrainRepoItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JetBrainRepoItemViewHolder {
        return JetBrainRepoItemViewHolder(
            binding = JetBrainRepoItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: JetBrainRepoItemViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }

    override fun onViewRecycled(holder: JetBrainRepoItemViewHolder) {
        super.onViewRecycled(holder)
        holder.onRecycled()
    }
}

private class DiffCallback : DiffUtil.ItemCallback<JetBrainRepoEntity>() {
    override fun areItemsTheSame(
        oldItem: JetBrainRepoEntity,
        newItem: JetBrainRepoEntity
    ) = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: JetBrainRepoEntity,
        newItem: JetBrainRepoEntity
    ) = oldItem == newItem
}