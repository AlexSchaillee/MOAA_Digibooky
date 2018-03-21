package com.moaa.api.member;

import com.moaa.service.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {"/member"})
public class MemberController {

    private MemberService memberService;
    private MemberMapper memberMapper;

    @Inject
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDTO registerMember(@RequestBody MemberDTO memberDTO){
        return memberMapper.toDto(memberService.registerMember(memberMapper.toDomain(memberDTO)));

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDTO> getAllMembersWithoutInss(){
        return memberService.getAllMembersWithoutInss().stream()
                .map(member->memberMapper.toDto(member))
                .collect(Collectors.toList());
    }



}
