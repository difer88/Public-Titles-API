package com.diegofernandes.publictitlesapi.resources;

import com.diegofernandes.publictitlesapi.model.Title;
import com.diegofernandes.publictitlesapi.model.TitleInfoDTO;
import com.diegofernandes.publictitlesapi.model.TitleRate;
import com.diegofernandes.publictitlesapi.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/titles")
public class TitleResource {

    @Autowired
    private TitleService titleService;

    @PostMapping(value = "/findbyname", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Title> findByName(@RequestParam String titleName){
        Title title = titleService.getTitleByName(titleName);
        return  ResponseEntity.ok().body(title);
    }

    @GetMapping(value = "/alltitlenames")
    public ResponseEntity<List<String>> findAllTitleNames(){
        List<String> titleNamesList = titleService.getTitlesListByWebsite();
        return ResponseEntity.ok().body(titleNamesList);
    }

    @PostMapping(value = "/lasttitlerate")
    public ResponseEntity<TitleInfoDTO> findLastRate(
            @RequestParam(value = "titleName", defaultValue = "") String titleName){
        TitleRate titleRate = titleService.getLastRate(titleName);
        TitleInfoDTO titleInfoDTO = TitleInfoDTO.builder().build();
        titleInfoDTO.fillTitleDTO(titleRate);
        return ResponseEntity.ok().body(titleInfoDTO);
    }

}
