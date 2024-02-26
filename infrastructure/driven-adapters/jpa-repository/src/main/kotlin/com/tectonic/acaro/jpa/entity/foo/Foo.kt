package com.tectonic.acaro.jpa.entity.foo

import com.sun.istack.NotNull
import java.util.Date
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.data.annotation.CreatedDate

@Entity
@Table(name = "foos")
data class Foo (
    @Id
    @NotNull
    @Column(name = "id", updatable = false, nullable = false)
    var id: UUID = UUID.randomUUID(),

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    var createdAt: Date? = null,

    @NotNull
    @Column(name = "title", nullable = false)
    var title: String? = null,
)