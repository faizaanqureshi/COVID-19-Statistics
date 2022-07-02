package com.faizaanqureshi.covidwebscraper;

import org.jsoup.nodes.Document;
import org.jsoup.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

import java.io.IOException;

public class Country {
    String country_name;
    String continent_name;
    Elements stats;
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
    String totalTests;
    String testsPer1M;
    String population;

    public Country(Document document, String country_name, String continent_name) {
        this.country_name = country_name;
        this. continent_name = continent_name;
        Element country = document.select("a.mt_a:containsOwn(" + country_name + ")").first().parent();
        this.stats = country.siblingElements();
        init();
    }

    public void init() {
        for (int i = 1; i < stats.size(); i++) {
            String value = stats.get(i).text();
            if (value.equals("")) value = "---";

            if (i == 1) {
                totalCases = value;
            } else if (i == 2) {
                newCases = value;
            } else if (i == 3) {
                totalDeaths = value;
            } else if (i == 4) {
                newDeaths = value;
            } else if (i == 5) {
                totalRecovered = value;
            } else if (i == 6) {
                newRecovered = value;
            } else if (i == 7) {
                activeCases = value;
            } else if (i == 8) {
                seriousCases = value;
            } else if (i == 9) {
                totCasesPer1M = value;
            } else if (i == 10) {
                deathsPer1M = value;
            } else if (i == 11) {
                totalTests = value;
            } else if (i == 12) {
                testsPer1M = value;
            } else if (i == 13) {
                population = value;
            }
        }
    }

    public void printStats() {
        System.out.println(country_name + ", " + continent_name + "\n");
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
            } else if (i == 10) {
                System.out.println("Total Tests: \n" + totalTests + "\n");
            } else if (i == 11) {
                System.out.println("Tests/1M pop: \n" + testsPer1M + "\n");
            } else if (i == 12) {
                System.out.println("Population: \n" + population + "\n");
            }
        }
    }
}
