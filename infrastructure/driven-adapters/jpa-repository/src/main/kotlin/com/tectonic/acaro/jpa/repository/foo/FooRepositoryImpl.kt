package com.tectonic.acaro.jpa.repository.foo

import com.tectonic.acaro.domain.exception.ResourceNotFoundException
import com.tectonic.acaro.domain.model.foo.Foo as FooModel
import com.tectonic.acaro.domain.driven_port.repository.FooRepository
import com.tectonic.acaro.domain.exception.UnprocessableEntityException
import com.tectonic.acaro.domain.model.page.Page
import com.tectonic.acaro.domain.model.page.Pagination
import com.tectonic.acaro.jpa.entity.foo.Foo
import com.tectonic.acaro.jpa.entity.foo.FooJpaMapper
import com.tectonic.acaro.jpa.util.PageableUtil.Companion.buildPageRequest
import com.tectonic.acaro.jpa.util.SpecificationUtil.Companion.buildSpecification
import java.util.UUID
import org.springframework.stereotype.Component

@Component
class FooRepositoryImpl(
    private val fooJpaRepository: FooJpaRepository,
    private val fooJpaMapper: FooJpaMapper,
): FooRepository {

    override fun findOneFooById(id: UUID): FooModel {
        return runCatching { fooJpaRepository.findById(id) }
            .getOrElse { throw ResourceNotFoundException(it.message ?: "Resource Not Found Exception") }
            .let { fooJpaMapper.toFooModel(it.get()) }
    }

    override fun findAllFoos(pagination: Pagination, search: String): Page<FooModel> {
        val spec = buildSpecification<Foo>(search)
        val pageRequest = buildPageRequest(pagination.page, pagination.size, pagination.sort)

        val page = fooJpaRepository.findAll(spec, pageRequest)
        return Page<FooModel>().apply {
            this.size = page.size
            this.totalElements = page.numberOfElements
            this.page = page.number
            this.number = page.number
            this.totalPages = page.totalPages
            this.empty = page.content.isEmpty()
            this.content = page.content.map { fooJpaMapper.toFooModel(it) }
        }
    }

    override fun saveOneFoo(foo: FooModel): FooModel {
        return runCatching { fooJpaRepository.save(fooJpaMapper.toFooEntity(foo)) }
            .getOrElse { throw UnprocessableEntityException(it.message ?: "Unprocessable entity exception") }
            .let { fooJpaMapper.toFooModel(it) }
    }


}