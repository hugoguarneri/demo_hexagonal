package com.tectonic.acaro.jpa.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

class PageableUtil {
    companion object {
        fun buildSortFromString(sort: String): Sort {
            return when {
                sort.isBlank() || sort.equals("unsorted", ignoreCase = true) -> Sort.unsorted()
                sort.contains(",ASC") || sort.contains(",asc") -> Sort.by(sort.split(",")[0]).ascending()
                sort.contains(",DESC") || sort.contains(",desc") -> Sort.by(sort.split(",")[0]).descending()
                else -> Sort.unsorted()
            }
        }

        fun buildPageRequest(page: Int, size: Int, sort: String): PageRequest {
            val sorted = buildSortFromString(sort)
            return PageRequest.of(page, size, sorted)
        }
    }
}
