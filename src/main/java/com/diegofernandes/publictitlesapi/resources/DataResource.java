package com.diegofernandes.publictitlesapi.resources;

import com.diegofernandes.publictitlesapi.constants.CommonConstants;
import com.diegofernandes.publictitlesapi.services.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/data")
public class DataResource {

    @Autowired
    private DataServiceImpl dataService;

    @RequestMapping(value = "/fileingestion", method = RequestMethod.GET)
    public ResponseEntity<String> insertTitleData(@RequestParam(value = "url", defaultValue = "") String fileURL){
        dataService.insertData(fileURL);
        return ResponseEntity.ok().body(CommonConstants.STATUS_DATA_INGESTION_SUCCESS);
    }

}
