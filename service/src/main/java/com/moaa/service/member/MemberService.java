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
}
