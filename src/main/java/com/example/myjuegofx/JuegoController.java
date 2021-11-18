package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class JuegoController {
    private StackPane pista;

    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;
    private Circle cañon;
    private double velocidad;
    private Timeline animacion;


    public JuegoController(Rectangle paredIzquierda, Rectangle paredArriba, Rectangle paredDerecha,
                           Rectangle paredAbajo, Rectangle tanque, StackPane pista,Circle cañon) {
        this.pista = pista;
        this.paredIzquierda = paredIzquierda;
        this.paredArriba = paredArriba;
        this.paredDerecha = paredDerecha;
        this.paredAbajo = paredAbajo;
        this.tanque = tanque;
        this.cañon=cañon;
        this.velocidad = 1;


        inicializarJuego();
        inicializarControles();
    }

    private void inicializarControles() {
        moverTanque();
        pista.setFocusTraversable(true);
    }

    private void inicializarJuego() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {
            moverTanque();
            detectarColision();
        }));
        animacion.setCycleCount(Animation.INDEFINITE);
        //animacion.play();
    }

    private void detectarColision() {
        if(tanque.getBoundsInParent().intersects(paredDerecha.getBoundsInParent())){
           // System.out.println("colision");
           //tanque.setTranslateX(tanque.getTranslateX()-2);
        }

    }
    private void moverTanque() {
        pista.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case RIGHT -> tanque.setTranslateX(tanque.getTranslateX()+2);
                case LEFT -> tanque.setTranslateX(tanque.getTranslateX()-2);
                case DOWN -> tanque.setTranslateY(tanque.getTranslateY()+2);
                case UP -> tanque.setTranslateY(tanque.getTranslateY()-2);
                //case RIGHT,UP -> tanque.setTranslateY(tanque.getTranslateY()+tanque.setTranslateX(tanque.getTranslateX()+2));
            }
            //animacion.play();
        });
        //tanque.setTranslateX(tanque.getTranslateX() + 1);//desplazamientoX*velocidad);
        //tanque.setTranslateY(tanque.getTranslateY() + 1);
        //tanque.setRotate(tanque.getRotate() + 10);
        //animacion.setRate();  aumentar velocidad
    }


}
