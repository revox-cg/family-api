package com.godsonpeya.family.service

import com.godsonpeya.family.dto.MemberRq
import com.godsonpeya.family.dto.MemberRs
import com.godsonpeya.family.dto.toMember
import com.godsonpeya.family.dto.toMemberRs
import com.godsonpeya.family.entity.Member
import com.godsonpeya.family.repository.MemberRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberServiceImpl(private val memberRepository: MemberRepository) : MemberService {
    override fun getAllMembers(): List<MemberRs> {
        return memberRepository.findAll().map { it.toMemberRs() }
    }

    override fun getMemberById(id: String): MemberRs? {
        return getMember(UUID.fromString(id)).toMemberRs()
    }

    override fun saveMember(memberRq: MemberRq): MemberRs {
        return memberRepository.save(memberRq.toMember()).toMemberRs()
    }

    override fun updateMember(id: String, memberRq: MemberRq): MemberRs {
        val member = getMember(UUID.fromString(id))
        member.apply {
            firstName = memberRq.firstName
            lastName = memberRq.lastName
        }
        return memberRepository.save(member).toMemberRs()
    }

    override fun deleteMember(id: UUID): String {
        val member = getMember(id)
        memberRepository.delete(member)
        return "Member deleted"
    }

    private fun getMember(id: UUID): Member {
        return memberRepository.findById(id).orElseThrow { IllegalArgumentException("Member not found") }
    }
}