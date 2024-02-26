package com.tectonic.acaro.domain.model.page

class Page<T> {
    var size: Int? = null
    var totalElements: Int? = null
    var page: Int? = null
    var number: Int? = null
    var totalPages: Int? = null
    var content: List<T> = emptyList()
    var empty: Boolean? = null
}
