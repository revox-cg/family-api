package com.godsonpeya.family.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID


@Entity
class Member(
    @Id
    @UuidGenerator
    val id: UUID? = null,
    var firstName: String,
    var lastName: String,
    @CreationTimestamp
    var createdAt: LocalDateTime? = null,
    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null
)