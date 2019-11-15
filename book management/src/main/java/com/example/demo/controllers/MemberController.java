package com.example.demo.controllers;

import com.example.demo.models.Member;
import com.example.demo.services.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("")
    public Member saveMember(@RequestBody Member member)
    {
        return memberService.saveMember(member);
    }


    @GetMapping("")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable("memberId") int memberId) {
        return memberService.getMemberById(memberId);
    }

    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable("memberId") int memberId,
                                @RequestBody Member updatedMember) {
        return memberService.updateMember(memberId, updatedMember);
    }

    @DeleteMapping("{memberId}")
    public Member deleteNumber(@PathVariable("memberId") int memberId){
        return memberService.deleteMember(memberId);
    }
}
