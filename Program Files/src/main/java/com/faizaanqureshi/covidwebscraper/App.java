package com.faizaanqureshi.covidwebscraper;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class App extends Application {

    public void start(Stage primaryStage) throws IOException {
        Scraper scraper = new Scraper("https://www.worldometers.info/coronavirus/#countries");
        Controller controller = new Controller(scraper);
        //scraper.IO();


        /*
        JMetro jMetro = new JMetro(Style.DARK);
        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        primaryStage.setTitle("COVID-19 Statistics");
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double height = screenBounds.getHeight();
        double width = screenBounds.getWidth();

        Scene scene = new Scene(root, width / 1.3, height / 1.3);

        primaryStage.setScene(scene);
        jMetro.setScene(scene);
        primaryStage.show();
         */
    }


    public static void main(String[] args) {
        launch();
        //scraper.IO();
    }
}