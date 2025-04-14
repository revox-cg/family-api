package com.godsonpeya.family.dto

import com.godsonpeya.family.entity.Member
import java.time.LocalDateTime
import java.util.*


class MemberRs(
    val id: UUID? = null,
    var firstName: String,
    var lastName: String,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)

fun Member.toMemberRs() = MemberRs(
    id = id,
    firstName = firstName,
    lastName = lastName,
    createdAt = createdAt,
    updatedAt = updatedAt
)