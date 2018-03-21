package com.moaa.api.lending;

import com.moaa.api.books.BookMapper;
import com.moaa.api.member.MemberMapper;
import com.moaa.domain.lending.LendContract;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendContractMapper {

    @Inject
    private BookMapper bookMapper;
    @Inject
    private MemberMapper memberMapper;

    LendContractDto toDto(LendContract lendContract){
        return LendContractDto.lendContractDto()
                .withBook(bookMapper.toDto(lendContract.getBook()))
                .withDueDate(lendContract.getDueDate())
                .withLendId(lendContract.getLendId())
                .withMember(memberMapper.toDto(lendContract.getMember()))
                .withDueDate(lendContract.getDueDate());
    }

    LendContract toDomain(LendContractDto lendContractDto){
        return new LendContract.LendContractBuilder()
                .withBook(bookMapper.toDomain(lendContractDto.getBook()))
                .withMember(memberMapper.toDomain(lendContractDto.getMember()))
                .build();
    }
}
