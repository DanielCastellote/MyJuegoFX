package com.example.myjuegofx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new VistaJuego(), 500, 500);
        stage.setTitle("Mi juego:");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}