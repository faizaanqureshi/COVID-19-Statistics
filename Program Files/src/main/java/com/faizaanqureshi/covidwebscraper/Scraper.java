package com.faizaanqureshi.covidwebscraper;

import org.jsoup.nodes.Document;
import org.jsoup.*;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.*;
import java.io.IOException;

public class Scraper {
    ArrayList<String> countryNames = new ArrayList<String>();
    Map<String, String> countriesContinentMap = new HashMap<String, String>();
    Document document;
    Continent NorthAmerica;
    Continent SouthAmerica;
    Continent Europe;
    Continent Africa;
    Continent Asia;
    Continent Oceania;
    World world;
    ArrayList<Country> countries = new ArrayList<Country>();


    public Scraper(String URL) {
        try {
            this.document = Jsoup.connect(URL).get();
            continentsInit();
            countriesInit();
            this.world = new World(document);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void continentsInit() {
        this.NorthAmerica = new Continent(document, "North America", "North", 2);
        this.SouthAmerica = new Continent(document, "South America", "South", 2);
        this.Europe = new Continent(document, "Europe", "Europe", 1);
        this.Africa = new Continent(document, "Africa", "Africa", 1);
        this.Asia = new Continent(document, "Asia", "Asia", 1);
        this.Oceania = new Continent(document, "Australia/Oceania", "Oceania", 1);
    }

    public void countriesInit() {
        Elements data = document.select("a.mt_a");

        for (int i = 0; i < data.size(); i++) {
            Element country = data.get(i);
            countryNames.add(country.text());
            Elements continent = data.get(i).parent().siblingElements().select("[data-continent]");
            countriesContinentMap.put(country.text(), continent.text());
        }

        for (int i = 0; i < countriesContinentMap.size(); i++) {
            String name = countryNames.get(i);
            countries.add(i, new Country(document, name, countriesContinentMap.get(name)));
        }
    }

    public void IO() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a Continent or Country, Press W for World Stats");
            String input = scanner.nextLine();

            if (input.equals("North America")) {
                NorthAmerica.printStats();
            } else if (input.equals("South America")) {
                SouthAmerica.printStats();
            } else if (input.equals("Europe")) {
                Europe.printStats();
            } else if (input.equals("Africa")) {
                Africa.printStats();
            } else if (input.equals("Asia")) {
                Asia.printStats();
            } else if (input.equals("Oceania")) {
                Oceania.printStats();
            } else if (input.equals("W")) {
                world.printStats();
            } else {
                for (int i = 0; i < countries.size(); i++) {
                    if (countries.get(i).country_name.equals(input)) {
                        countries.get(i).printStats();
                    }
                }
            }
        }
    }

    public static String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}
