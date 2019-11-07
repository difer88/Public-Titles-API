package com.diegofernandes.webdatacollector;

import com.diegofernandes.webdatacollector.constants.CommonConstants;
import com.diegofernandes.webdatacollector.model.Title;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);

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

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
