package com.moaa.api.lending;

import com.moaa.domain.lending.LendContract;

import javax.inject.Named;

@Named
public class LendContractMapper {

    LendContractDto toDto(LendContract lendContract){
        return LendContractDto.lendContractDto()
                .withBook(lendContract.getBook())
                .withDueDate(lendContract.getDueDate())
                .withLendId(lendContract.getLendId())
                .withDueDate(lendContract.getDueDate());
    }

    LendContract toDomain(LendContractDto lendContractDto){
        return new LendContract.LendContractBuilder()
                .withBook(lendContractDto.getBook())
                .withMember(lendContractDto.getMember())
                .build();
    }
}
