package com.godsonpeya.family.service

import com.godsonpeya.family.dto.MemberRq
import com.godsonpeya.family.dto.MemberRs
import com.godsonpeya.family.entity.Member
import java.util.UUID

interface MemberService {

    fun getAllMembers(): List<MemberRs>
    fun getMemberById(id: String): MemberRs?
    fun saveMember(memberRq: MemberRq): MemberRs
    fun updateMember(id: String, memberRq: MemberRq): MemberRs
    fun deleteMember(id: UUID): String
}