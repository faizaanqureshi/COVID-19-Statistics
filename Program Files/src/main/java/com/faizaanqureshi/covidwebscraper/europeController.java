package com.faizaanqureshi.covidwebscraper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class europeController {
    Scene primaryScene;
    Controller controller;
    africaController africaController;
    asiaController asiaController;
    northAmericaController northAmericaController;
    southAmericaController southAmericaController;
    oceaniaController oceaniaController;
    countryController countryController;
    author authorController;
    FXMLLoader loader;
    Parent africaRoot;
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

    public europeController(Scraper scraper, Stage primaryStage) {
        try {
            loader = new FXMLLoader(getClass().getResource("europe.fxml"));
            loader.setController(this);
            africaRoot = loader.load();
            //africaWindow = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());

            totalCases.setText(scraper.Europe.totalCases);
            newCases.setText(scraper.Europe.newCases);
            totalDeaths.setText(scraper.Europe.totalDeaths);
            newDeaths.setText(scraper.Europe.newDeaths);
            totalRecovered.setText(scraper.Europe.totalRecovered);
            newRecovered.setText(scraper.Europe.newRecovered);
            activeCases.setText(scraper.Europe.activeCases);
            seriousCases.setText(scraper.Europe.seriousCases);

            if (newCases.getText().equals("")) newCases.setText("---");
            if (newDeaths.getText().equals("")) newDeaths.setText("---");
            if (newRecovered.getText().equals("")) newRecovered.setText("---");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void controllerInit(Controller controller, africaController africaController, asiaController asiaController,
                               northAmericaController northAmericaController, southAmericaController southAmericaController
                                , oceaniaController oceaniaController, countryController countryController,
                               author authorController) {
        this.controller = controller;
        this.africaController = africaController;
        this.asiaController = asiaController;
        this.northAmericaController = northAmericaController;
        this.southAmericaController = southAmericaController;
        this.oceaniaController = oceaniaController;
        this.countryController = countryController;
        this.authorController = authorController;
    }

    public void show(Scene primaryScene) {
        this.primaryScene = primaryScene;
        primaryScene.setRoot(africaRoot);
    }

    public void handleWorld() {
        controller.show(primaryScene);
    }
    public void handleAfrica() { africaController.show(primaryScene); }
    public void handleAsia() { asiaController.show(primaryScene); }
    public void handleNorthAmerica() { northAmericaController.show(primaryScene); }
    public void handleSouthAmerica() { southAmericaController.show(primaryScene); }
    public void handleOceania() { oceaniaController.show(primaryScene); }
    public void handleCountry() { countryController.show(primaryScene); }
    public void handleAuthor() { authorController.show(); }
}
