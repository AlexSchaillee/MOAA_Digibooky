package com.moaa.domain.lending;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LendRepository {

    private LendRepository lendRepository;

    @Inject
    public LendRepository(LendRepository lendRepository) {
        this.lendRepository = lendRepository;
    }

//    public LendContract

}
