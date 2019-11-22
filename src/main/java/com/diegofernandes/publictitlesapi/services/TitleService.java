package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.model.Title;
import com.diegofernandes.publictitlesapi.model.TitleRate;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitleService {

    Title getTitleByName(String titleName);

    List<String> getTitlesListByWebsite();

    TitleRate getLastRate(@Param("titleName") String titleName);

}
