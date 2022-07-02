package com.faizaanqureshi.covidwebscraper;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class World {
    Elements data;
    String totalCases;
    String newCases;
    String totalDeaths;
    String newDeaths;
    String totalRecovered;
    String newRecovered;
    String activeCases;
    String seriousCases;
    String totCasesPer1M;
    String deathsPer1M;

    public World(Document document) {
        this.data = document.select("td:contains(World)").get(0).siblingElements();
        init();
    }

    public void init() {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).text().equals("")) {
                break;
            } else {
                if (i == 1) {
                    totalCases = data.get(i).text();
                } else if (i == 2) {
                    newCases = data.get(i).text();
                } else if (i == 3) {
                    totalDeaths = data.get(i).text();
                } else if (i == 4) {
                    newDeaths = data.get(i).text();
                } else if (i == 5) {
                    totalRecovered = data.get(i).text();
                } else if (i == 6) {
                    newRecovered = data.get(i).text();
                } else if (i == 7) {
                    activeCases = data.get(i).text();
                } else if (i == 8) {
                    seriousCases = data.get(i).text();
                } else if (i == 9) {
                    totCasesPer1M = data.get(i).text();
                } else if (i == 10) {
                    deathsPer1M = data.get(i).text();
                }
            }
        }
    }

    public void printStats() {
        System.out.println("The World" + "\n");
        for (int i = 0; i < 13; i++) {
            if (i == 0) {
                System.out.println("Total Cases: \n" + totalCases + "\n");
            } else if (i == 1) {
                System.out.println("New Cases: \n" + newCases + "\n");
            } else if (i == 2) {
                System.out.println("Total Deaths: \n" + totalDeaths + "\n");
            } else if (i == 3) {
                System.out.println("New Deaths: \n" + newDeaths + "\n");
            } else if (i == 4) {
                System.out.println("Total Recovered: \n" + totalRecovered + "\n");
            } else if (i == 5) {
                System.out.println("New Recovered: \n" + newRecovered + "\n");
            } else if (i == 6) {
                System.out.println("Active Cases: \n" + activeCases + "\n");
            } else if (i == 7) {
                System.out.println("Serious/Critical Cases: \n" + seriousCases + "\n");
            } else if (i == 8) {
                System.out.println("Tot Cases/1M pop: \n" + totCasesPer1M + "\n");
            } else if (i == 9) {
                System.out.println("Deaths/1M pop: \n" + deathsPer1M + "\n");
            }
        }
    }
}
