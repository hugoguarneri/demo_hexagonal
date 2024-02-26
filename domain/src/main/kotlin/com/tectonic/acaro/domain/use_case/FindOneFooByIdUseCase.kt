package com.tectonic.acaro.domain.use_case

import com.tectonic.acaro.domain.driven_port.repository.FooRepository
import com.tectonic.acaro.domain.model.foo.Foo
import java.util.UUID
import org.slf4j.LoggerFactory

class FindOneFooByIdUseCase(
    private val fooRepository: FooRepository,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun execute(id: UUID): Foo {
        return fooRepository.findOneFooById(id)
    }
}