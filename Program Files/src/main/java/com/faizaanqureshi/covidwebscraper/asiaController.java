package com.faizaanqureshi.covidwebscraper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class asiaController {
    Scene primaryScene;
    Controller controller;
    africaController africaController;
    europeController europeController;
    northAmericaController northAmericaController;
    southAmericaController southAmericaController;
    oceaniaController oceaniaController;
    countryController countryController;
    author authorController;
    FXMLLoader loader;
    Parent asiaRoot;
    @FXML
    public Label totalCases;
    @FXML
    public Label newCases;
    @FXML
    public Label totalDeaths;
    @FXML
    public Label newDeaths;
    @FXML
    public Label totalRecovered;
    @FXML
    public Label newRecovered;
    @FXML
    public Label activeCases;
    @FXML
    public Label seriousCases;
    Scene africaWindow;

    public asiaController(Scraper scraper, Stage primaryStage) {
        try {
            loader = new FXMLLoader(getClass().getResource("asia.fxml"));
            loader.setController(this);
            asiaRoot = loader.load();

            totalCases.setText(scraper.Asia.totalCases);
            newCases.setText(scraper.Asia.newCases);
            totalDeaths.setText(scraper.Asia.totalDeaths);
            newDeaths.setText(scraper.Asia.newDeaths);
            totalRecovered.setText(scraper.Asia.totalRecovered);
            newRecovered.setText(scraper.Asia.newRecovered);
            activeCases.setText(scraper.Asia.activeCases);
            seriousCases.setText(scraper.Asia.seriousCases);

            if (newCases.getText().equals("")) newCases.setText("---");
            if (newDeaths.getText().equals("")) newDeaths.setText("---");
            if (newRecovered.getText().equals("")) newRecovered.setText("---");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void controllerInit(Controller controller, africaController africaController, europeController europeController,
                               northAmericaController northAmericaController, southAmericaController southAmericaController,
                               oceaniaController oceaniaController, countryController countryController,
                               author authorController) {
        this.controller = controller;
        this.africaController = africaController;
        this.europeController = europeController;
        this.northAmericaController = northAmericaController;
        this.southAmericaController = southAmericaController;
        this.oceaniaController = oceaniaController;
        this.countryController = countryController;
        this.authorController = authorController;
    }

    public void show(Scene primaryScene) {
        this.primaryScene = primaryScene;
        primaryScene.setRoot(asiaRoot);
    }

    public void handleWorld() {
        controller.show(primaryScene);
    }
    public void handleAfrica() { africaController.show(primaryScene); }
    public void handleEurope() { europeController.show(primaryScene); }
    public void handleNorthAmerica() { northAmericaController.show(primaryScene); }
    public void handleSouthAmerica() { southAmericaController.show(primaryScene); }
    public void handleOceania() { oceaniaController.show(primaryScene); }
    public void handleCountry() { countryController.show(primaryScene); }
    public void handleAuthor() { authorController.show(); }
}
