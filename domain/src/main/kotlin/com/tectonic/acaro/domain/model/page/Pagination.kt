package com.tectonic.acaro.domain.model.page

data class Pagination(
    val page: Int,
    val size: Int,
    val sort: String,
)
