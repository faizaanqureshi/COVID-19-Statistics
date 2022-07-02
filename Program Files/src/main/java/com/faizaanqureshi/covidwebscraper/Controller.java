package com.faizaanqureshi.covidwebscraper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class Controller {
    Scene primaryScene;
    FXMLLoader loader;
    africaController africaController;
    asiaController asiaController;
    europeController europeController;
    northAmericaController northAmericaController;
    southAmericaController southAmericaController;
    oceaniaController oceaniaController;
    countryController countryController;
    Parent mainRoot;

    Scraper scraper;
    Stage primaryStage;
    //@FXML Button btnScene1, btnScene2;
    JMetro jMetro = new JMetro(Style.DARK);


    @FXML
    public Label totalCasesWorldWide;
    @FXML
    public Label newCasesWorldWide;
    @FXML
    public Label totalDeathsWorldWide;
    @FXML
    public Label newDeathsWorldWide;
    @FXML
    public Label totalRecoveredWorldWide;
    @FXML
    public Label newRecoveredWorldWide;
    @FXML
    public Label activeCasesWorldWide;
    @FXML
    public Label seriousCasesWorldWide;
    @FXML
    public Label totCasesPerMillionWorldWide;
    @FXML
    public Label deathsPerMillionWorldWide;
    @FXML
    public Label title;
    @FXML
    public MenuItem africa;
    @FXML
    public MenuItem asia;
    @FXML
    public MenuItem europe;
    @FXML
    public MenuItem northAmerica;
    @FXML
    public MenuItem oceania;
    @FXML
    public MenuItem southAmerica;
    author authorController;




    public Controller(Scraper scraper) {
        primaryStage = new Stage();

        try {
            loader = new FXMLLoader(getClass().getResource("page1.fxml"));
            loader.setController(this);
            mainRoot = loader.load();

            africaController = new africaController(scraper, primaryStage);
            asiaController = new asiaController(scraper, primaryStage);
            europeController = new europeController(scraper, primaryStage);
            northAmericaController = new northAmericaController(scraper, primaryStage);
            southAmericaController = new southAmericaController(scraper, primaryStage);
            oceaniaController = new oceaniaController(scraper, primaryStage);
            countryController = new countryController(scraper);
            authorController = new author();

            africaController.controllerInit(this, asiaController, europeController, northAmericaController,
                    southAmericaController, oceaniaController, countryController, authorController);
            asiaController.controllerInit(this, africaController, europeController, northAmericaController,
                    southAmericaController, oceaniaController, countryController, authorController);
            europeController.controllerInit(this, africaController, asiaController, northAmericaController,
                    southAmericaController, oceaniaController, countryController, authorController);
            northAmericaController.controllerInit(this, africaController, asiaController, europeController,
                    southAmericaController, oceaniaController, countryController , authorController);
            southAmericaController.controllerInit(this, africaController, asiaController, europeController,
                    northAmericaController, oceaniaController, countryController, authorController);
            oceaniaController.controllerInit(this, africaController, asiaController, europeController,
                    northAmericaController, southAmericaController, countryController, authorController);
            countryController.controllerInit(this, africaController, asiaController, europeController,
                    northAmericaController, southAmericaController, oceaniaController, authorController);

            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double height = screenBounds.getHeight();
            double width = screenBounds.getWidth();

            this.jMetro = new JMetro(Style.DARK);
            primaryStage.getIcons().add(new Image("file:logo_512.png"));
            primaryStage.setTitle("COVID-19 Statistics");
            primaryStage.initStyle(StageStyle.DECORATED);

            primaryScene = new Scene(mainRoot, width / 1.3, height / 1.3);
            primaryStage.setScene(primaryScene);

            jMetro.setScene(primaryScene);
            this.scraper = scraper;

            dataInit();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void author() {
        authorController.show();
    }

    public void show(Scene primaryScene) {
        primaryScene.setRoot(mainRoot);
    }
    public void dataInit() {
        totalCasesWorldWide.setText(scraper.world.totalCases);
        newCasesWorldWide.setText(scraper.world.newCases);
        totalDeathsWorldWide.setText(scraper.world.totalDeaths);
        newDeathsWorldWide.setText(scraper.world.newDeaths);
        totalRecoveredWorldWide.setText(scraper.world.totalRecovered);
        newRecoveredWorldWide.setText(scraper.world.newRecovered);
        activeCasesWorldWide.setText(scraper.world.activeCases);
        seriousCasesWorldWide.setText(scraper.world.seriousCases);
        totCasesPerMillionWorldWide.setText(scraper.world.totCasesPer1M);
        deathsPerMillionWorldWide.setText(scraper.world.deathsPer1M);
    }
    /*
    public void africaInit() {
        totalCasesContinent.setText(scraper.Africa.totalCases);
        newCasesContinent.setText(scraper.Africa.newCases);
        totalDeathsContinent.setText(scraper.Africa.totalDeaths);
        newDeathsContinent.setText(scraper.Africa.newDeaths);
        totalRecoveredContinent.setText(scraper.Africa.totalRecovered);
        newRecoveredContinent.setText(scraper.Africa.newRecovered);
        activeCasesContinent.setText(scraper.Africa.activeCases);
        seriousCasesContinent.setText(scraper.Africa.seriousCases);
    }

     */
    /*
    public void asiaInit() {
        totalCasesContinent.setText(scraper.Asia.totalCases);
        newCasesContinent.setText(scraper.Asia.newCases);
        totalDeathsContinent.setText(scraper.Asia.totalDeaths);
        newDeathsContinent.setText(scraper.Asia.newDeaths);
        totalRecoveredContinent.setText(scraper.Asia.totalRecovered);
        newRecoveredContinent.setText(scraper.Asia.newRecovered);
        activeCasesContinent.setText(scraper.Asia.activeCases);
        seriousCasesContinent.setText(scraper.Asia.seriousCases);
    }

     */

    public void handleAfrica() {
        africaController.show(primaryScene);
    }
    public void handleAsia() {
        asiaController.show(primaryScene);
    }
    public void handleEurope() {
        europeController.show(primaryScene);
    }
    public void handleNorthAmerica() {
        northAmericaController.show(primaryScene);
    }
    public void handleSouthAmerica() {
        southAmericaController.show(primaryScene);
    }
    public void handleOceania() {
        oceaniaController.show(primaryScene);
    }
    public void handleCountry() { countryController.show(primaryScene); }

    /*
    public void handleAsia() throws Exception {
        double width = title.getScene().getWidth();
        double height = title.getScene().getHeight();
        Scene scene = new Scene(asiaLoader.load(), width, height);
        asiaInit();
        primaryStage.setScene(scene);
        jMetro.setScene(scene);
    }

     */
    /*
    public void handleAsia () throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        Stage window = (Stage) btnScene2.getScene().getWindow();
        double width = btnScene2.getScene().getWidth();
        double height = btnScene2.getScene().getHeight();
        Scene scene = new Scene(root, width, height);
        window.setScene(scene);
        jMetro.setScene(scene);
    }

     */
}