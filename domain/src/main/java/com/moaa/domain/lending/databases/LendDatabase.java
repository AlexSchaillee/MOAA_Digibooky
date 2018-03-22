package com.moaa.domain.lending.databases;

import com.moaa.domain.lending.LendContract;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class LendDatabase {

    private List<LendContract> lendContractList;

    public LendDatabase() {
        this.lendContractList = new ArrayList<>();
    }

    public List<LendContract> getLendContractList() {
        return Collections.unmodifiableList(lendContractList);
    }

    public LendContract addLendContract(LendContract lendContract) throws IllegalArgumentException {
        if (lendContractListContainsBookId(lendContract)) {
            throw new IllegalArgumentException(
                    "Book " + lendContract.getBook().getTitle() + " already lent");
        }
        if (lendContractListContainsLendId(lendContract)) {
            throw new IllegalArgumentException(
                    "LendContract with Id " + lendContract.getLendId() + " already exists in database");
        }
        lendContractList.add(lendContract);
        return lendContract;
    }

    private boolean lendContractListContainsBookId(LendContract lendContract) {
        boolean contains = false;
        for (LendContract item : lendContractList) {
            if (item.getBook().getId().equals(lendContract.getBook().getId())) {
                contains = true;
            }
        }
        return contains;
    }

    private boolean lendContractListContainsLendId(LendContract lendContract) {
        boolean contains = false;
        for (LendContract item : lendContractList) {
            if (item.getLendId().equals(lendContract.getLendId())) {
                contains = true;
            }
        }
        return contains;
    }

    public LendContract removeLendContract(LendContract lendContract) throws IllegalArgumentException {
        if (!lendContractList.contains(lendContract)) {
            throw new IllegalArgumentException("LendContract with id " + lendContract.getLendId() + " not found");
        }
        lendContractList.remove(lendContract);
        return lendContract;
    }
}
