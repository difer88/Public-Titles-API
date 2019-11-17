package com.diegofernandes.publictitlesapi.services;

import com.diegofernandes.publictitlesapi.model.Title;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public void insertData(String fileURL) {

        try {

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(fileURL).openStream());

            POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);

            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator linhas = sheet.rowIterator();

            while (linhas.hasNext()) {
                
                HSSFRow linha = (HSSFRow) linhas.next();
                Iterator celulas = linha.cellIterator();

                Title title = new Title();

                while (celulas.hasNext()) {
                    HSSFCell celula = (HSSFCell) celulas.next();
                    int index = celula.getColumnIndex();

                    System.out.println("Index: " + celula.getColumnIndex() + "Valor: " + celula.toString());

                }
            }

            System.out.println(linhas);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
