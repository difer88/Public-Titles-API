package com.diegofernandes.publictitlesapi.repository;

import com.diegofernandes.publictitlesapi.model.TitleRate;
import org.springframework.beans.factory.annotation.Autowired;

public class TitleRateRepositoryImpl {

    @Autowired
    private TitleRateRepository titleRateRepository;

    public TitleRate getLastRateId(Integer titleId){
        return titleRateRepository.getLastRate(titleId);
    }

}
