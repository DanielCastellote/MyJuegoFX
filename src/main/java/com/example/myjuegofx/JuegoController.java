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


    private double desplX;
    private double desplY;
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
        this.velocidad = 2;


        inicializarJuego();
        inicializarControles();
    }

    private void inicializarControles() {
        pista.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case SPACE:
                    animacion.play();
                    desplY=0;
                    desplX=0;
                    break;
                case RIGHT:
                    desplX=1*velocidad;
                    desplY=0;
                    break;
                case LEFT:
                    desplX=-1*velocidad;
                    desplY=0;
                    break;
                case DOWN :
                    desplX=0;
                    desplY=1*velocidad;
                    break;
                case UP :
                    desplX=0;
                    desplY=-1*velocidad;
                    break;
                case A :
                    tanque.setRotate(tanque.getRotate()+10);
                    break;
                case D :
                    tanque.setRotate(tanque.getRotate()-10);
                    break;
            }
            //animacion.play();
        });
       /* tanque.setOnMouseMoved(r->{
            tanque.setRotate(tanque.getRotate()+70);
        });*/
        pista.setFocusTraversable(true);
    }

    private void inicializarJuego() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {
            moverTanque();
            detectarColision();
        }));
        animacion.setCycleCount(Animation.INDEFINITE);

    }

    private void detectarColision() {
        if(tanque.getBoundsInParent().intersects(paredDerecha.getBoundsInParent())){
           desplX=0;
        }
        if(tanque.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())){
            desplX=0;
        }
        if(tanque.getBoundsInParent().intersects(paredAbajo.getBoundsInParent())){
            desplY=0;
        }
        if(tanque.getBoundsInParent().intersects(paredArriba.getBoundsInParent())){
            desplY=0;
        }

    }
    private void moverTanque() {
        tanque.setTranslateX(tanque.getTranslateX()+desplX);
        tanque.setTranslateY(tanque.getTranslateY()+desplY);

    }


}
