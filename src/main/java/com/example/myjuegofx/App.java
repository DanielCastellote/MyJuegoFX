package com.example.myjuegofx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new VistaJuego(), 500, 500);
        stage.setTitle("Mi juego:");
        stage.setScene(scene);
        stage.getIcons().add(new Image("https://key0.cc/images/preview/40456_38559973bb6b5cf93213a7d5c030c3f3.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}