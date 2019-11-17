package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.model.Title;
import com.diegofernandes.publictitlesapi.repository.TitleRepository;
import com.diegofernandes.publictitlesapi.repository.TitleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements  TitleService{

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public Title getTitleByName(String titleName) {
        return titleRepository.findByName(titleName);
    }

    @Override
    public List<String> getTitlesListByWebsite() {
        return titleRepository.getTitlesListByWebsite();
    }
}
