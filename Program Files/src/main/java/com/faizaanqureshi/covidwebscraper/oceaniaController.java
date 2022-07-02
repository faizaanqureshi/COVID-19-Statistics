package com.faizaanqureshi.covidwebscraper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class oceaniaController {
    Scene primaryScene;
    Controller controller;
    africaController africaController;
    asiaController asiaController;
    europeController europeController;
    northAmericaController northAmericaController;
    southAmericaController southAmericaController;
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

    public oceaniaController(Scraper scraper, Stage primaryStage) {
        try {
            loader = new FXMLLoader(getClass().getResource("oceania.fxml"));
            loader.setController(this);
            africaRoot = loader.load();
            //africaWindow = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());

            totalCases.setText(scraper.Oceania.totalCases);
            newCases.setText(scraper.Oceania.newCases);
            totalDeaths.setText(scraper.Oceania.totalDeaths);
            newDeaths.setText(scraper.Oceania.newDeaths);
            totalRecovered.setText(scraper.Oceania.totalRecovered);
            newRecovered.setText(scraper.Oceania.newRecovered);
            activeCases.setText(scraper.Oceania.activeCases);
            seriousCases.setText(scraper.Oceania.seriousCases);

            if (newCases.getText().equals("")) newCases.setText("---");
            if (newDeaths.getText().equals("")) newDeaths.setText("---");
            if (newRecovered.getText().equals("")) newRecovered.setText("---");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void controllerInit(Controller controller, africaController africaController, asiaController asiaController,
                               europeController europeController, northAmericaController northAmericaController,
                               southAmericaController southAmericaController, countryController countryController,
                               author authorController) {

        this.controller = controller;
        this.africaController = africaController;
        this.asiaController = asiaController;
        this.europeController = europeController;
        this.northAmericaController = northAmericaController;
        this.southAmericaController = southAmericaController;
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
    public void handleEurope() { europeController.show(primaryScene); }
    public void handleNorthAmerica() { northAmericaController.show(primaryScene); }
    public void handleSouthAmerica() { southAmericaController.show(primaryScene); }
    public void handleCountry() { countryController.show(primaryScene); }
    public void handleAuthor() { authorController.show(); }
}
