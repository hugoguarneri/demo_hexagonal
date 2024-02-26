package com.tectonic.acaro.jpa.repository.foo

import com.tectonic.acaro.jpa.entity.foo.Foo
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FooJpaRepository : JpaRepository<Foo, UUID>, JpaSpecificationExecutor<Foo> {

    @Query(value = "SELECT COUNT(*) FROM boards", nativeQuery = true)
    fun countAll(): Long

    fun findByIdIn(idList: List<UUID>) : List<Foo>

}