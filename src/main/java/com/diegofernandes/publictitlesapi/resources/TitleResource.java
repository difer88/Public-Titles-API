package com.diegofernandes.publictitlesapi.resources;

import com.diegofernandes.publictitlesapi.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/titles")
public class TitleResource {

    @Autowired
    private TitleService titleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<String>> findAll(){

        List<String> titleNamesList = titleService.getNamesList();

        return ResponseEntity.ok().body(titleNamesList);

    }

}
