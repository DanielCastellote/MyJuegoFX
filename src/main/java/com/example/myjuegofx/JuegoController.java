package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class JuegoController {
    private StackPane pista;

    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;
    private double velocidad;
    private Timeline animacion;


    public JuegoController(Rectangle paredIzquierda, Rectangle paredArriba, Rectangle paredDerecha,
                           Rectangle paredAbajo, Rectangle tanque, StackPane pista) {
        this.pista = pista;
        this.paredIzquierda = paredIzquierda;
        this.paredArriba = paredArriba;
        this.paredDerecha = paredDerecha;
        this.paredAbajo = paredAbajo;
        this.tanque = tanque;
        this.velocidad = 1;


        inicializarJuego();
        inicializarControles();
    }

    private void inicializarControles() {
        pista.setOnKeyPressed(e -> animacion.play());
        pista.setFocusTraversable(true);
    }

    private void inicializarJuego() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {
            moverTanque();
        }));
        animacion.setCycleCount(Animation.INDEFINITE);
        //animacion.play();
    }

    private void moverTanque() {

        tanque.setTranslateX(tanque.getTranslateX() + 1);
        tanque.setTranslateY(tanque.getTranslateY() + 1);
        tanque.setRotate(tanque.getRotate() + 10);
    }


}
