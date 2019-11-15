package com.example.demo.services;

import com.example.demo.models.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private List<Member> members = new ArrayList<>();
    private int autoIncrement = 1;

    public Member saveMember(Member member) {
        member.setId(autoIncrement++);

        members.add(member);

        return member;
    }

    public List<Member> getAllMembers() {
        return this.members;
    }

    public Member getMemberById(int memberId){
        for(Member member : members){
            if(member.getId() == memberId){
                return member;
            }
        }
        return null;
    }

    public Member updateMember(int memberId, Member updatedMember){
        for(Member member : members){
            if(member.getId() == memberId){
                member.setEmail(updatedMember.getEmail());
                member.setName(updatedMember.getName());
                member.setPassword(updatedMember.getPassword());
                member.setPhoneNumber(updatedMember.getPhoneNumber());
                return member;
            }
        }
        updatedMember.setId(autoIncrement++);
        members.add(updatedMember);
        return null;
    }

    public Member deleteMember(int memberId){
        for(Member member : members){
            if(member.getId() == memberId){
                members.remove(member);
                return member;
            }
        }
        return null;
    }



}
