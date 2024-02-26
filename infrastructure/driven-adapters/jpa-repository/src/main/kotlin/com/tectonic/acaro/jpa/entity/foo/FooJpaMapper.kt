package com.tectonic.acaro.jpa.entity.foo

import com.tectonic.acaro.domain.model.foo.Foo as FooModel
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
interface FooJpaMapper {
    fun toFooModel(fooEntity: Foo): FooModel
    fun toFooEntity(fooModel: FooModel): Foo
}