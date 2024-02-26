package com.tectonic.acaro.api.dto.foo

import java.util.Date
import java.util.UUID

data class FooDto(
    var id: UUID? = null,
    var createdAt: Date? = null,
    var title: String? = null,
)
