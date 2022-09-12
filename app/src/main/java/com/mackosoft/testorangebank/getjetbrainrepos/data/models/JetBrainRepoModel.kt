package com.mackosoft.testorangebank.getjetbrainrepos.data.models

import com.google.gson.annotations.SerializedName
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity

data class JetBrainRepoModel(
    override val id: Long,
    @SerializedName("full_name")
    override val fullName: String,
    override val description: String,
    override val forks: Int,
    @SerializedName("open_issues")
    override val openIssues: Int,
    override val watchers: Int,
) : JetBrainRepoEntity(id, fullName, description, forks, openIssues, watchers)