package com.tectonic.acaro.api.controller

import com.tectonic.acaro.api.dto.foo.FooApiMapper
import com.tectonic.acaro.api.dto.foo.FooDto
import com.tectonic.acaro.domain.model.page.Page
import com.tectonic.acaro.domain.model.page.Pagination
import com.tectonic.acaro.domain.use_case.FindAllFoosUseCase
import com.tectonic.acaro.domain.use_case.FindOneFooByIdUseCase
import java.util.UUID
import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    value = ["/api/v1/foo"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class FooController(
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val findAllFoosUseCase: FindAllFoosUseCase,
    private val findOneFooByIdUseCase: FindOneFooByIdUseCase,
    private val fooApiMapper: FooApiMapper,
) {

    @GetMapping("")
    fun findAll(
        @RequestParam(value = "page", defaultValue = "0", required = false) page: Int,
        @RequestParam(value = "size", defaultValue = "20", required = false) size: Int,
        @RequestParam(value = "sort", defaultValue = "", required = false) sort: String,
        @RequestParam(value = "search", defaultValue = "", required = false) search: String
    ): ResponseEntity<Page<FooDto>> {
        return findAllFoosUseCase.execute(Pagination(page, size, sort), search)
            .let { fooApiMapper.toFooDtoPage(it) }
            .let { ResponseEntity(it, HttpStatus.OK) }
    }

    @GetMapping("/{id}")
    fun show(
        @PathVariable id: UUID
    ): ResponseEntity<FooDto> {
        return findOneFooByIdUseCase.execute(id)
            .let { fooApiMapper.toFooDto(it) }
            .let { ResponseEntity(it, HttpStatus.OK) }
    }


}
