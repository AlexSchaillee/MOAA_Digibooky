package com.moaa.domain.member;

import com.moaa.domain.member.databases.MemberDataBase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class MemberRepository {

    @Inject
    private MemberDataBase memberDataBase;

    public MemberRepository(MemberDataBase memberDataBase) {
        this.memberDataBase = memberDataBase;
    }

    public Member createMember (Member member)throws IllegalArgumentException{
        return memberDataBase.addMember(member);
    }

    public List<Member> getAllMembersWithoutInss (){
        return memberDataBase.getMemberList().stream()
                .map(this::maskInss)
                .collect(Collectors.toList());
    }

    private Member maskInss(Member member){
        Member returnMember = Member.MemberBuilder.buildMember()
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName())
                .withStreetName(member.getStreetName())
                .withStreetNumber(member.getStreetNumber())
                .withCityName(member.getCityName())
                .withPostalCode(member.getPostalCode())
                .withEmail(member.getEmail())
                .withInss("**Masked**")
                .build();
        return returnMember.setId(member.getId());
    }
}
