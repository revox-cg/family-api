package com.godsonpeya.family.controller

import com.godsonpeya.family.dto.MemberRq
import com.godsonpeya.family.dto.MemberRs
import com.godsonpeya.family.service.MemberService
import org.springframework.web.bind.annotation.*
import java.util.UUID


@RequestMapping("/members")
@RestController
class MemberController(private val memberService: MemberService) {

    @GetMapping
    fun getMembers(): List<MemberRs> = memberService.getAllMembers()

    @GetMapping("/{id}")
    fun getMember(@PathVariable id: UUID): MemberRs? = memberService.getMemberById(id)

    @PostMapping
    fun createMember(@RequestBody memberRq: MemberRq): MemberRs = memberService.saveMember(memberRq)

    @PutMapping("/{id}")
    fun updateMember(@PathVariable id: UUID, @RequestBody memberRq: MemberRq): MemberRs =
        memberService.updateMember(id, memberRq)

    @DeleteMapping("/{id}")
    fun deleteMember(@PathVariable id: UUID): String = memberService.deleteMember(id)
}