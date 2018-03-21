package com.moaa.domain.lending;

import com.moaa.domain.lending.databases.LendDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LendRepository {

    private LendDatabase lendDataBase;

    @Inject
    public LendRepository(LendDatabase lendDataBase) {
        this.lendDataBase = lendDataBase;
    }

    public LendContract addLendContract(LendContract lendContract)throws IllegalArgumentException{
        if (databaseContainsLendForBookId(lendContract)){
            throw new IllegalArgumentException
                    ("Book with id: "
                            + lendContract.getLendId()
                            +" already rented to member with memberId: "
                            + lendContract.getMember().getId());
        }
        lendDataBase.addLendContract(lendContract);
        return lendContract;
    }

    private boolean databaseContainsLendForBookId (LendContract lendContract){
        boolean contains = false;
        for (LendContract item: lendDataBase.getLendContractList()) {
            if (item.getBook().getId().equals(lendContract.getBook().getId())){
                contains = true;
            }
        }
        return contains;
    }

    public LendContract removeContract (LendContract lendContract){
        return lendDataBase.removeLendContract(lendContract);
    }

    public List<LendContract> getLendContractList() {
        return lendDataBase.getLendContractList();
    }
}
