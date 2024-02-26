package com.tectonic.acaro.domain.use_case

import com.tectonic.acaro.domain.driven_port.repository.FooRepository
import com.tectonic.acaro.domain.driven_port.repository.Transaction
import com.tectonic.acaro.domain.model.foo.Foo
import org.slf4j.LoggerFactory

class SaveFooUseCase(
    private val fooRepository: FooRepository,
    private val transaction: Transaction,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun execute(foo: Foo): Foo {
        return transaction.run { fooRepository.saveOneFoo(foo) }
    }
}