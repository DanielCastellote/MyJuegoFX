package com.example.myjuegofx;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VistaJuego extends BorderPane {

    private final StackPane pista;
    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;

    private Rectangle bala;
    private JuegoController controlador;

    private Enemigos enemigos;


    public VistaJuego() {
        //Instanciar
        this.paredIzquierda = new Rectangle();
        this.paredArriba = new Rectangle();
        this.paredDerecha = new Rectangle();
        this.paredAbajo = new Rectangle();
        this.tanque = new Rectangle();
        this.pista = new StackPane();
        this.bala= new Rectangle();
        this.controlador = new JuegoController(paredIzquierda, paredArriba, paredDerecha, paredAbajo, tanque, pista,bala);
        this.enemigos= new Enemigos();



        //Inicializar

        pista.setStyle("-fx-background-image: url(fondo.png)");

        pista.setMinSize(0,0);
        paredIzquierda.setFill(Color.BLACK);
        paredIzquierda.heightProperty().bind(pista.heightProperty());
        paredIzquierda.widthProperty().bind(pista.widthProperty().divide(20));

        paredDerecha.setFill(Color.BLACK);
        paredDerecha.heightProperty().bind(pista.heightProperty());
        paredDerecha.widthProperty().bind(pista.widthProperty().divide(20));

        paredArriba.setFill(Color.BLACK);
        paredArriba.heightProperty().bind(pista.heightProperty().divide(20));
        paredArriba.widthProperty().bind(pista.widthProperty());

        paredAbajo.setFill(Color.BLACK);
        paredAbajo.heightProperty().bind(pista.heightProperty().divide(20));
        paredAbajo.widthProperty().bind(pista.widthProperty());

        tanque.setFill(Color.GRAY);
        tanque.heightProperty().bind(paredIzquierda.widthProperty());
        tanque.widthProperty().bind(paredIzquierda.widthProperty());
        tanque.setFill(new ImagePattern(new Image("nave.png")));

        bala.heightProperty().bind(pista.heightProperty().divide(25));
        bala.widthProperty().bind(pista.widthProperty().divide(35));
        bala.setFill(new ImagePattern(new Image("4.png")));


        //Colocar

        pista.getChildren().addAll(paredIzquierda, paredArriba, paredAbajo, paredDerecha, tanque,bala);
        pista.setAlignment(paredIzquierda, Pos.CENTER_LEFT);
        pista.setAlignment(paredDerecha, Pos.CENTER_RIGHT);
        pista.setAlignment(paredArriba, Pos.TOP_CENTER);
        pista.setAlignment(paredAbajo, Pos.BOTTOM_CENTER);
        pista.setAlignment(tanque, Pos.CENTER);
        pista.setAlignment(bala,Pos.CENTER);



       // pista.setAlignment(cañon,Pos.CENTER);

        this.setCenter(pista);

        //Instanciar controlador
    }
}