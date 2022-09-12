package com.mackosoft.testorangebank.getjetbrainrepos.data.models

import com.google.gson.annotations.SerializedName
import com.mackosoft.testorangebank.getjetbrainrepos.domain.entities.JetBrainRepoEntity

data class JetBrainRepoModel(
    val id: Long,
    @SerializedName("full_name")
    val fullName: String?,
    val description: String?,
    val forks: Int?,
    @SerializedName("open_issues")
    val openIssues: Int?,
    val watchers: Int?,
)