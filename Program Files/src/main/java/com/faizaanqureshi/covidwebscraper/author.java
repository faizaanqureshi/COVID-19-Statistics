package com.faizaanqureshi.covidwebscraper;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;
import java.net.URI;
import java.awt.*;
import java.net.URISyntaxException;

public class author {
    FXMLLoader loader;
    Parent aboutRoot;
    Stage aboutStage;
    JMetro jMetro;
    Scene aboutScene;

    public author() {
        aboutStage = new Stage();

        try {
            loader = new FXMLLoader(getClass().getResource("author.fxml"));
            loader.setController(this);
            aboutRoot = loader.load();

            Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            double height = screenBounds.getHeight();
            double width = screenBounds.getWidth();

            this.jMetro = new JMetro(Style.DARK);
            aboutStage.getIcons().add(new Image("file:logo_512.png"));
            aboutStage.setTitle("Author");
            aboutStage.initStyle(StageStyle.DECORATED);

            aboutScene = new Scene(aboutRoot, width / 1.6, height / 2);
            aboutStage.setScene(aboutScene);
            aboutStage.setResizable(false);
            jMetro.setScene(aboutScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        aboutStage.show();
    }

    public void instagram() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.instagram.com/faizaanqureshi_/?hl=en"));
    }

    public void github() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/faizaanqureshi"));
    }

    public void linkedin() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/faizaan-qureshi-193b6319b/?originalSubdomain=ca"));
    }
}
