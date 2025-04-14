package com.godsonpeya.family.dto

import com.godsonpeya.family.entity.Member
import java.time.LocalDateTime
import java.util.*


class MemberRq(
    val id: UUID? = null,
    var firstName: String,
    var lastName: String,
)

fun MemberRq.toMember() = Member(
    id = id,
    firstName = firstName,
    lastName = lastName
)