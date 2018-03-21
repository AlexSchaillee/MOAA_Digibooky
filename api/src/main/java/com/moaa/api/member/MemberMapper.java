package com.moaa.api.member;

import com.moaa.domain.member.Member;
import com.moaa.domain.member.email.Email;

import javax.inject.Named;

@Named
public class MemberMapper {

        MemberDTO toDto(Member member){
            return MemberDTO.memberDTO()
                    .withFirstName(member.getFirstName())
                    .withLastName(member.getLastName())
                    .withStreetName(member.getStreetName())
                    .withStreetNumber(member.getStreetNumber())
                    .withCityName(member.getCityName())
                    .withPostalCode(member.getPostalCode())
                    .withId(member.getId().toString())
                    .withEmail(member.getEmail().toString())
                    .withInss(member.getInss());
        }

        Member toDomain(MemberDTO memberDto){
            return new Member.MemberBuilder()
                    .withFirstName(memberDto.getFirstName())
                    .withLastName(memberDto.getLastName())
                    .withStreetName(memberDto.getStreetName())
                    .withStreetNumber(memberDto.getStreetNumber())
                    .withCityName(memberDto.getCityName())
                    .withPostalCode(memberDto.getPostalCode())
                    .withEmail(Email.of(memberDto.getEmail()))
                    .withInss(memberDto.getInss())
                    .build();
        }

}
