package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.model.Title;
import com.diegofernandes.publictitlesapi.model.TitleRate;
import com.diegofernandes.publictitlesapi.repository.TitleRateRepository;
import com.diegofernandes.publictitlesapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements  TitleService{

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private TitleRateRepository titleRateRepository;

    @Override
    public Title getTitleByName(String titleName) {
        return titleRepository.findByName(titleName);
    }

    @Override
    public List<String> getTitlesListByWebsite() {
        return titleRepository.getTitlesListByWebsite();
    }

    @Override
    public TitleRate getLastRate(String titleName) {

        Title title = titleRepository.findByName(titleName);

        TitleRate titleRate = titleRateRepository.getLastRate(title.getId());

        titleRate.setTitle(title);

        return titleRate;

    }
}
