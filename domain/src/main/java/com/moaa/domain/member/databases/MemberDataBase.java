package com.moaa.domain.member.databases;

import com.moaa.domain.member.Member;
import com.moaa.domain.member.email.Email;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class MemberDataBase {

    private List<Member> memberList;

    public MemberDataBase() {
        this.memberList = new ArrayList<>();
    }

    public List<Member> getMemberList() {
        return Collections.unmodifiableList(memberList);
    }

    public Member addMember(Member member) throws IllegalArgumentException {
        if(memberListContainsInSS(member.getInss())){
            throw new IllegalArgumentException
                    ("User with Inss "+member.getInss()+" already in database");
        }
        if(memberListContainsEmail(member.getEmail())){
            throw new IllegalArgumentException
                    ("User with email "+member.getEmail()+" already found in database");
        }
        memberList.add(member);
        return member;
    }

    private boolean memberListContainsEmail(Email email) {
        boolean containsEmail=false;
        for (Member item:memberList) {
            if (item.getEmail().getEmailAddress().equals(email.getEmailAddress())) {containsEmail=true;}
        }
        return containsEmail;
    }

    private boolean memberListContainsInSS(String inss){
        boolean containsInss=false;
        for (Member item:memberList) {
            if (item.getInss().equals(inss)) {containsInss=true;}
        }
        return containsInss;
    }
}
