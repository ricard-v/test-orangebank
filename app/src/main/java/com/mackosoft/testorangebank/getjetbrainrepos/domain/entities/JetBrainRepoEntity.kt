package com.mackosoft.testorangebank.getjetbrainrepos.domain.entities

open class JetBrainRepoEntity(
    open val id: Long,
    open val fullName: String,
    open val description: String,
    open val forks: Int,
    open val openIssues: Int,
    open val watchers: Int,
)
