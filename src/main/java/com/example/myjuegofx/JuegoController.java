package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;



public class JuegoController {
    private StackPane pista;

    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;
    private Rectangle bala;

    private double desplX;
    private double desplY;

    private double desBala;

    private double velocidad;
    private Timeline animacion;

    private Enemigos enem;

//Configurar rutas para multiplataforma
    Media cancionGame = new Media("file:///C:/Users/danie/Downloads/guerra-de-las-galaxias-starwras-musica-.mp3");
    MediaPlayer cancion= new MediaPlayer(cancionGame);
    AudioClip golpePared = new AudioClip("file:///C:/Users/danie/Downloads/PS_METAL_KNOCK_1.mp3");



    public JuegoController(Rectangle paredIzquierda, Rectangle paredArriba, Rectangle paredDerecha,
                           Rectangle paredAbajo, Rectangle tanque, StackPane pista,Rectangle bala) {
        this.pista = pista;
        this.paredIzquierda = paredIzquierda;
        this.paredArriba = paredArriba;
        this.paredDerecha = paredDerecha;
        this.paredAbajo = paredAbajo;
        this.tanque = tanque;
        this.bala= bala;
        this.velocidad = 1.5;



        inicializarJuego();
        inicializarControles();

    }

    private void inicializarControles() {
        pista.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case SPACE:
                    enem= new Enemigos(paredIzquierda, paredArriba, paredDerecha, paredAbajo, tanque, pista,bala);
                    animacion.play();
                    desplY=0;
                    desplX=0;
                    cancion.play();
                    cancion.setCycleCount(MediaPlayer.INDEFINITE);
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
                case S:
                    desplX=0;
                    desplY=0;
                    break;
                case A :
                    tanque.setRotate(tanque.getRotate()-20);
                    break;
                case D :
                    tanque.setRotate(tanque.getRotate()+20);
                    break;
                case R:
                    disparar();

                    break;
            }
            //animacion.play();
        });

        pista.setFocusTraversable(true);
    }

    private void inicializarJuego() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {
            moverTanque();
            detectarColision();
            moverDisparo();

        }));
        animacion.setCycleCount(Animation.INDEFINITE);
    }

    private void detectarColision() {
        if(tanque.getBoundsInParent().intersects(paredDerecha.getBoundsInParent())){
           desplX=-1;
           golpePared.play();
        }
        if(tanque.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())){
            desplX=1;
            golpePared.play();
        }
        if(tanque.getBoundsInParent().intersects(paredAbajo.getBoundsInParent())){
            desplY=-1;
            golpePared.play();
        }
        if(tanque.getBoundsInParent().intersects(paredArriba.getBoundsInParent())){
            desplY=1;
            golpePared.play();
        }

    }
    private void moverTanque() {

        tanque.setTranslateX(tanque.getTranslateX()+desplX*velocidad);
        tanque.setTranslateY(tanque.getTranslateY()+desplY*velocidad);

    }

    private void disparar(){

        //bala=new Rectangle();

        bala.setTranslateY(tanque.getTranslateY()-5);
        bala.setTranslateX(tanque.getTranslateX());


    }

    private void moverDisparo(){

        bala.setTranslateX(bala.getTranslateX());
        bala.setTranslateY(bala.getTranslateY()-10);

    }


}
