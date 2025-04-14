package com.godsonpeya.family.repository

import com.godsonpeya.family.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MemberRepository : JpaRepository<Member, UUID>