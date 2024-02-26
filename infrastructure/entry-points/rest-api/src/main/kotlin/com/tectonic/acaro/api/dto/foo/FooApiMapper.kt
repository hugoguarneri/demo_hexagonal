package com.tectonic.acaro.api.dto.foo

import com.tectonic.acaro.domain.model.foo.Foo
import com.tectonic.acaro.domain.model.page.Page
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
)
interface FooApiMapper {
    fun toFooDto(fooModel: Foo): FooDto
    fun toFooDtoPage(fooModelPage: Page<Foo>): Page<FooDto>
}