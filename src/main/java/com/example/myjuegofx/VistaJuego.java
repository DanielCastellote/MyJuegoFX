package com.example.myjuegofx;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaJuego extends BorderPane {

    private final StackPane pista;
    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;
    private JuegoController controlador;

    public VistaJuego() {
        //Instanciar
        this.paredIzquierda = new Rectangle();
        this.paredArriba = new Rectangle();
        this.paredDerecha = new Rectangle();
        this.paredAbajo = new Rectangle();
        this.tanque = new Rectangle();
        this.pista = new StackPane();
        this.controlador = new JuegoController(paredIzquierda, paredArriba, paredDerecha, paredAbajo, tanque, pista);

        //Inicializar

        paredIzquierda.setFill(Color.BLACK);
        paredIzquierda.heightProperty().bind(pista.heightProperty());
        paredIzquierda.widthProperty().bind(pista.widthProperty().divide(25));

        paredDerecha.setFill(Color.BLACK);
        paredDerecha.heightProperty().bind(pista.heightProperty());
        paredDerecha.widthProperty().bind(pista.widthProperty().divide(25));

        paredArriba.setFill(Color.BLACK);
        paredArriba.heightProperty().bind(pista.heightProperty().divide(25));
        paredArriba.widthProperty().bind(pista.widthProperty());

        paredAbajo.setFill(Color.BLACK);
        paredAbajo.heightProperty().bind(pista.heightProperty().divide(25));
        paredAbajo.widthProperty().bind(pista.widthProperty());

        tanque.setFill(Color.GREEN);
        tanque.heightProperty().bind(paredIzquierda.widthProperty());
        tanque.widthProperty().bind(paredIzquierda.widthProperty());


        //Colocar

        pista.getChildren().addAll(paredIzquierda, paredArriba, paredAbajo, paredDerecha, tanque);
        pista.setAlignment(paredIzquierda, Pos.CENTER_LEFT);
        pista.setAlignment(paredDerecha, Pos.CENTER_RIGHT);
        pista.setAlignment(paredArriba, Pos.TOP_CENTER);
        pista.setAlignment(paredAbajo, Pos.BOTTOM_CENTER);
        pista.setAlignment(tanque, Pos.CENTER);
        this.setCenter(pista);


        //Instanciar controlador


    }
}