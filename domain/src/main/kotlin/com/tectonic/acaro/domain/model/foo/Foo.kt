package com.tectonic.acaro.domain.model.foo

import java.time.LocalDateTime
import java.util.UUID

data class Foo (
    var id: UUID? = null,
    var createdAt: LocalDateTime? = null,
    var title: String? = null,
)
