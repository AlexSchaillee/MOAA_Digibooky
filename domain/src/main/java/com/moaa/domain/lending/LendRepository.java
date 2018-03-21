package com.moaa.domain.lending;

import com.moaa.domain.lending.databases.LendDatabase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendRepository {

    private LendDatabase lendDataBase;

    @Inject
    public LendRepository(LendDatabase lendDataBase) {
        this.lendDataBase = lendDataBase;
    }

    public LendContract addLendContract(LendContract lendContract)throws IllegalArgumentException{
        if (databaseContainsLendContract(lendContract)){
            throw new IllegalArgumentException("Database already contains contract with id: " +lendContract.getLendId());
        }
        lendDataBase.addLendContract(lendContract);
        return lendContract;
    }

    private boolean databaseContainsLendContract (LendContract lendContract){
        boolean contains = false;
        for (LendContract item: lendDataBase.getLendContractList()) {
            if (item.getLendId().equals(lendContract.getLendId())){
                contains = true;
            }
        }
        return contains;
    }

}
