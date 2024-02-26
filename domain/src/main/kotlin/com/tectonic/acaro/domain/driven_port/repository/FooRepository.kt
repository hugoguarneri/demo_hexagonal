package com.tectonic.acaro.domain.driven_port.repository

import com.tectonic.acaro.domain.model.foo.Foo
import com.tectonic.acaro.domain.model.page.Page
import com.tectonic.acaro.domain.model.page.Pagination
import java.util.UUID

interface FooRepository {
    fun findOneFooById(id: UUID): Foo
    fun findAllFoos(pagination: Pagination, search: String): Page<Foo>
    fun saveOneFoo(foo: Foo): Foo
}