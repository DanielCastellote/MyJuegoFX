package com.example.myjuegofx;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class VistaJuego extends BorderPane {

    private final StackPane pista;
    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;
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
        this.controlador = new JuegoController(paredIzquierda, paredArriba, paredDerecha, paredAbajo, tanque, pista);
        this.enemigos= new Enemigos();

        //Inicializar

        pista.setStyle("-fx-background-image: url(https://www.arielcelaya.com.ar/multimedia/wp-content/uploads/2015/10/FondoLejos.png)");

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
        tanque.setStyle("-fx-fill: url(https://thumbs.dreamstime.com/b/icono-resumido-del-pixel-avi%C3%B3n-completamente-editable-141541266.jpg)");



        //Colocar

        pista.getChildren().addAll(paredIzquierda, paredArriba, paredAbajo, paredDerecha, tanque);
        pista.setAlignment(paredIzquierda, Pos.CENTER_LEFT);
        pista.setAlignment(paredDerecha, Pos.CENTER_RIGHT);
        pista.setAlignment(paredArriba, Pos.TOP_CENTER);
        pista.setAlignment(paredAbajo, Pos.BOTTOM_CENTER);
        pista.setAlignment(tanque, Pos.CENTER);
       // pista.setAlignment(cañon,Pos.CENTER);

        this.setCenter(pista);

        //Instanciar controlador
    }
}