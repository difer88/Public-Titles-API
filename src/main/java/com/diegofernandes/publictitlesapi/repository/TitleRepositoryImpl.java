package com.diegofernandes.publictitlesapi.repository;

import com.diegofernandes.publictitlesapi.constants.CommonConstants;
import com.diegofernandes.publictitlesapi.model.Title;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TitleRepositoryImpl {

    @Autowired
    private TitleRepository titleRepository;

    public Title getTitleByName(String titleName){
        return titleRepository.findByName(titleName);
    }

    public List<String> getTitlesListByWebsite(){

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
                        titleObject.setName(eachText.get(0));
                        titleObject.setDueDate(eachText.get(1));
                    }

                    lista.add(titleObject);

                }
            }

            for (Title t : lista){
                System.out.println(t.getName());
                System.out.println(t.getDueDate());
            }

            lista.forEach(titulo -> titleNamesList.add(titulo.getName()));
            
            return titleNamesList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return titleNamesList;
    }

}
