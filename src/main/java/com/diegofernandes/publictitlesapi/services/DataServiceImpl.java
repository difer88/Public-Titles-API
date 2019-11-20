package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.constants.CommonConstants;
import com.diegofernandes.publictitlesapi.model.Title;
import com.diegofernandes.publictitlesapi.model.TitleRate;
import com.diegofernandes.publictitlesapi.repository.TitleRateRepository;
import com.diegofernandes.publictitlesapi.repository.TitleRepository;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private TitleRateRepository titleRateRepository;

    @Override
    public void insertData(String titleName, String fileURL) {

        Title title = titleRepository.findByName(titleName);

        try {

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(fileURL).openStream());
            POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator linhas = sheet.rowIterator();

            TitleRate titleRate;
            Map<Integer, String> lineCells;

            while (linhas.hasNext()) {

                lineCells = new HashMap<>();
                HSSFRow linha = (HSSFRow) linhas.next();
                Iterator celulas = linha.cellIterator();

                while (celulas.hasNext()) {
                    HSSFCell celula = (HSSFCell) celulas.next();
                    lineCells.put(celula.getColumnIndex(), celula.toString());
                    System.out.println("Index: " + celula.getColumnIndex() + " Valor: " + celula.toString());
                }

                titleRate = TitleRate.builder()
                        .quoteTime(lineCells.get(CommonConstants.QUOTE_TIME_INDEX))
                        .ratePurchase(Double.valueOf(lineCells.get(CommonConstants.RATE_PURCHASE_INDEX)))
                        .rateSale(Double.valueOf(lineCells.get(CommonConstants.RATE_SALE_INDEX)))
                        .unityValuePurchase(new BigDecimal(lineCells.get(CommonConstants.UNITY_VALUE_PURCHASE_INDEX)))
                        .unityValueSale(new BigDecimal(lineCells.get(CommonConstants.UNITY_VALUE_SALE_INDEX)))
                        .title(title)
                        .build();

                titleRateRepository.save(titleRate);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
