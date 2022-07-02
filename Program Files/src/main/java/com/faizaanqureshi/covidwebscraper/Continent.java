package com.faizaanqureshi.covidwebscraper;

import org.jsoup.nodes.Document;
import org.jsoup.*;
import org.jsoup.select.Elements;
import java.util.ArrayList;

import java.io.IOException;


public class Continent {
    String totalCases;
    String newCases;
    String totalDeaths;
    String newDeaths;
    String totalRecovered;
    String newRecovered;
    String activeCases;
    String seriousCases;

    public Continent(Document document, String place, String keyword, int Syllables) {
        Elements cont = document.getElementsByAttributeValue("data-continent", place).first().children();

        for (int i = 2; i < cont.size(); i++) {
            if (i == 2) {
                this.totalCases = cont.get(i).text();
            } else if (i == 3) {
                this.newCases = cont.get(i).text();
            } else if (i == 4) {
                this.totalDeaths = cont.get(i).text();
            } else if (i == 5) {
                this.newDeaths = cont.get(i).text();
            } else if (i == 6) {
                this.totalRecovered = cont.get(i).text();
            } else if (i == 7) {
                this.newRecovered = cont.get(i).text();
            } else if (i == 8) {
                this.activeCases = cont.get(i).text();
            } else if (i == 9) {
                this.seriousCases = cont.get(i).text();
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

    public void printStats() {
        System.out.println("Total Cases: " + totalCases);
        System.out.println("New Cases: "+ newCases);
        System.out.println("Total Deaths: " + totalDeaths);
        System.out.println("New Deaths: " + newDeaths);
        System.out.println("Total Recovered: " + totalRecovered);
        System.out.println("New Recovered: " + newRecovered);
        System.out.println("Active Cases: " + activeCases);
        System.out.println("Serious/Critical Cases: " + seriousCases);
    }
}
