package com.moaa.service.member;

import com.moaa.domain.member.Member;
import com.moaa.domain.member.MemberRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberService {

    private final MemberRepository memberRepository;

    @Inject
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembersWithoutInss() {
        return memberRepository.getAllMembersWithoutInss();
    }

    public Member registerMember(Member member) {
        return memberRepository.createMember(member);
    }

    public Member getMemberById(String memberId) throws IllegalArgumentException {
        Member returnMember = null;
        for (Member item : memberRepository.getAllMembersWithoutInss()) {
            if (item.getId().toString().equals(memberId)) {
                return item;
            }
        }
        throw new IllegalArgumentException("member with " + memberId + " not found");
    }
}
