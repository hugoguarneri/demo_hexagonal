package com.tectonic.acaro.domain.use_case

import com.tectonic.acaro.domain.driven_port.repository.FooRepository
import com.tectonic.acaro.domain.model.foo.Foo
import com.tectonic.acaro.domain.model.page.Page
import com.tectonic.acaro.domain.model.page.Pagination
import org.slf4j.LoggerFactory

class FindAllFoosUseCase(
    private val fooRepository: FooRepository,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun execute(pagination: Pagination, search: String): Page<Foo> {
        return fooRepository.findAllFoos(pagination, search)
    }
}