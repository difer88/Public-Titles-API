package com.diegofernandes.webdatacollector.repository;

import com.diegofernandes.webdatacollector.constants.CommonConstants;
import com.diegofernandes.webdatacollector.model.Title;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TitleRepositoryImpl implements TitleRepository{

    public List<String> getNamesList(){

        List<String> titleNamesList = new ArrayList<>();

        Document doc;

        try {

            doc = Jsoup.connect(CommonConstants.URL_TESOURO_DIRETO).userAgent(CommonConstants.USER_AGENT).get();

            String title = doc.title();
            System.out.println("Título da página : " + title);

            Elements tabela = doc.getElementsByClass("tabelaPrecoseTaxas sanfonado");

            Title titleObject;
            List<Title> lista = new ArrayList<>();

            for (Element item : tabela) {

                Elements itens = item.getElementsByClass("camposTesouroDireto");

                for (Element tituloTesouro : itens){

                    Elements columns = tituloTesouro.children();

                    titleObject = new Title();

                    List<String> eachText = columns.eachText();

                    for(int i = 0; i <= eachText.size() - 1; i++){
                        titleObject.setTitle(eachText.get(0));
                        titleObject.setExpiry(eachText.get(1));
                        titleObject.setYieldRate(eachText.get(2));
                        titleObject.setUnitPrice(eachText.get(3));
                    }

                    lista.add(titleObject);

                }
            }

            for (Title t : lista){
                System.out.println(t.getTitle());
                System.out.println(t.getExpiry());
                System.out.println(t.getYieldRate());
                System.out.println(t.getUnitPrice());
            }

            lista.forEach(titulo -> titleNamesList.add(titulo.getTitle()));
            
            return titleNamesList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return titleNamesList;
    }

}
