package com.diegofernandes.publictitlesapi.resources;

import com.diegofernandes.publictitlesapi.constants.CommonConstants;
import com.diegofernandes.publictitlesapi.services.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/data")
public class DataResource {

    @Autowired
    private DataServiceImpl dataService;

    @PostMapping(value = "/fileingestion")
    public ResponseEntity<String> insertTitleData(
            @RequestParam(value = "titleName", defaultValue = "") String titleName,
            @RequestParam(value = "url", defaultValue = "") String fileURL){
        dataService.insertData(titleName, fileURL);
        return ResponseEntity.ok().body(CommonConstants.STATUS_DATA_INGESTION_SUCCESS);
    }

}
