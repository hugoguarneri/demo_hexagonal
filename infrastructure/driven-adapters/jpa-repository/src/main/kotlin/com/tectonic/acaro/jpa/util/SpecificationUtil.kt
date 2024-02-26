package com.tectonic.acaro.jpa.util

import org.springframework.data.jpa.domain.Specification
import com.sipios.springsearch.SpecificationsBuilder

class SpecificationUtil {
    companion object {
        fun <T> buildSpecification(search: String?): Specification<T>? {
            if (search.isNullOrEmpty()) {
                return null
            }
            return SpecificationsBuilder<T>()
                .withSearch(search)
                .build()
        }
    }
}