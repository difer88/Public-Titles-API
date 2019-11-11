package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.repository.TitleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    private TitleRepositoryImpl titleRepository;

    public List<String> getNamesList() {
        return titleRepository.getNamesList();
    }
}
