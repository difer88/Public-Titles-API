package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.model.Title;

import java.util.List;

public interface TitleService {

    Title getTitleByName(String titleName);

    List<String> getTitlesListByWebsite();

}
