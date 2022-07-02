package com.faizaanqureshi.covidwebscraper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class countryController {
    Scene primaryScene;
    FXMLLoader loader;
    Parent countryRoot;
    Controller controller;
    africaController africaController;
    asiaController asiaController;
    europeController europeController;
    northAmericaController northAmericaController;
    southAmericaController southAmericaController;
    oceaniaController oceaniaController;
    author authorController;
    Scraper scraper;
    ArrayList<String> countryNames = new ArrayList<String>();
    ArrayList<Country> countries = new ArrayList<Country>();
    public TextField searchBar;
    public ListView<String> listView;
    public Label title;
    public Label totalCases;
    public Label newCases;
    public Label totalDeaths;
    public Label newDeaths;
    public Label totalRecovered;
    public Label newRecovered;
    public Label activeCases;
    public Label seriousCases;
    public Label totCasesPerMillion;
    public Label deathsPerMillion;
    public Label totalTests;
    public Label testsPerMillion;
    public Label population;


    public countryController(Scraper scraper) {
        try {
            loader = new FXMLLoader(getClass().getResource("countries.fxml"));
            loader.setController(this);
            countryRoot = loader.load();
            this.scraper = scraper;
            countryNames = removeDuplicates(scraper.countryNames);
            countries = scraper.countries;
            System.out.println(countryNames);
            initialize();

            totalCases.setText(scraper.world.totalCases);
            newCases.setText(scraper.world.newCases);
            totalDeaths.setText(scraper.world.totalDeaths);
            newDeaths.setText(scraper.world.newDeaths);
            totalRecovered.setText(scraper.world.totalRecovered);
            newRecovered.setText(scraper.world.newRecovered);
            activeCases.setText(scraper.world.activeCases);
            seriousCases.setText(scraper.world.seriousCases);
            totCasesPerMillion.setText(scraper.world.totCasesPer1M);
            deathsPerMillion.setText(scraper.world.deathsPer1M);
            totalTests.setText("---");
            testsPerMillion.setText("---");
            population.setText("---");

            listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                String selectedItem = listView.getSelectionModel().getSelectedItem();
                int index = listView.getSelectionModel().getSelectedIndex();

                for (int i = 0; i < countries.size(); i++) {
                    if (countries.get(i).country_name.equals(selectedItem)) {
                        countryInit(countries.get(i));
                    }
                }

                System.out.println("Item selected : " + selectedItem + ", Item index : " + index);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countryInit(Country country) {
        title.setText(country.country_name + " COVID-19 Statistics");
        totalCases.setText(country.totalCases);
        newCases.setText(country.newCases);
        totalDeaths.setText(country.totalDeaths);
        newDeaths.setText(country.newDeaths);
        totalRecovered.setText(country.totalRecovered);
        newRecovered.setText(country.newRecovered);
        activeCases.setText(country.activeCases);
        seriousCases.setText(country.seriousCases);
        totCasesPerMillion.setText(country.totCasesPer1M);
        deathsPerMillion.setText(country.deathsPer1M);
        totalTests.setText(country.totalTests);
        testsPerMillion.setText(country.testsPer1M);
        population.setText(country.population);
    }

    public ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> currentList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (currentList.contains(list.get(i))) continue;
            currentList.add(list.get(i));
        }

        return currentList;
    }

    public void controllerInit(Controller controller, africaController africaController, asiaController asiaController,
                               europeController europeController, northAmericaController northAmericaController,
                               southAmericaController southAmericaController, oceaniaController oceaniaController,
                               author authorController) {
        this.controller = controller;
        this.africaController = africaController;
        this.asiaController = asiaController;
        this.europeController = europeController;
        this.northAmericaController = northAmericaController;
        this.southAmericaController = southAmericaController;
        this.oceaniaController = oceaniaController;
        this.authorController = authorController;
    }

    public void show(Scene primaryScene) {
        this.primaryScene = primaryScene;
        primaryScene.setRoot(countryRoot);
    }

    public void search() {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(), countryNames));
    }

    public void initialize() {
        listView.getItems().addAll(countryNames);
    }

    public List<String> searchList(String searchWords, List<String> listOfStrings) {
        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
                }).collect(Collectors.toList());
    }

    public void handleWorld() {
        controller.show(primaryScene);
    }
    public void handleAfrica() { africaController.show(primaryScene); }
    public void handleAsia() { asiaController.show(primaryScene); }
    public void handleEurope() { europeController.show(primaryScene); }
    public void handleNorthAmerica() { northAmericaController.show(primaryScene); }
    public void handleSouthAmerica() { southAmericaController.show(primaryScene); }
    public void handleOceania() { oceaniaController.show(primaryScene); }
    public void handleAuthor() { authorController.show(); }
}
