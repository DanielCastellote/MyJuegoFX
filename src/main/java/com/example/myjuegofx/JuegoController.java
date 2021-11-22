package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;


public class JuegoController {
    private StackPane pista;

    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;
    private Rectangle enemigo;


    private double desplX;
    private double desplY;

    private double eneX;
    private double eneY;

    private double velocidad;
    private Timeline animacion;


    Media cancionGame = new Media("file:///C:/Users/danie/Downloads/guerra-de-las-galaxias-starwras-musica-.mp3");
    MediaPlayer cancion= new MediaPlayer(cancionGame);
    AudioClip golpePared = new AudioClip("file:///C:/Users/danie/Downloads/PS_METAL_KNOCK_1.mp3");



    public JuegoController(Rectangle paredIzquierda, Rectangle paredArriba, Rectangle paredDerecha,
                           Rectangle paredAbajo, Rectangle tanque, StackPane pista) {
        this.pista = pista;
        this.paredIzquierda = paredIzquierda;
        this.paredArriba = paredArriba;
        this.paredDerecha = paredDerecha;
        this.paredAbajo = paredAbajo;
        this.tanque = tanque;
        this.velocidad = 1.5;


        inicializarJuego();
        inicializarControles();

    }

    private void inicializarControles() {
        pista.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case SPACE:
                    crearEnemigos(1);
                    animacion.play();
                    desplY=0;
                    desplX=0;
                    cancion.play();
                    eneX=1;
                    eneY=0;
                    //tanque.setVisible(true);
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
            }
            //animacion.play();
        });


        pista.setFocusTraversable(true);
    }

    private void inicializarJuego() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {
            moverTanque();
            detectarColision();
            //crearEnemigos(2);
            moverEnemigo();

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

        if(tanque.getBoundsInParent().intersects(enemigo.getBoundsInParent())){

            enemigo.setVisible(false);
        }
        if(enemigo.getBoundsInParent().intersects(paredDerecha.getBoundsInParent())){
           eneX=-1;
           //golpePared.play();
        }
        if(enemigo.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())){
            eneX=1;
           //golpePared.play();
        }


    }
    private void moverTanque() {

        tanque.setTranslateX(tanque.getTranslateX()+desplX*velocidad);
        tanque.setTranslateY(tanque.getTranslateY()+desplY*velocidad);

    }
    private void moverEnemigo(){

        enemigo.setTranslateX(enemigo.getTranslateX()+eneX*velocidad);

    }

    private void crearEnemigos(int cantidadEnemigos){

        for(int i=0; i<cantidadEnemigos;i++){
           enemigo = new Rectangle(20,20);
           enemigo.setTranslateX((int) Math.floor(Math.random() * 200 -200));
           enemigo.setTranslateY((int) Math.floor(Math.random() * 200 -200));


           enemigo.setStyle("-fx-fill: url(https://w7.pngwing.com/pngs/187/1011/png-transparent-space-invaders-arcade-game-video-game-gamenight-game-angle-text-thumbnail.png)");
          //moverEnemigo();

            pista.getChildren().add(enemigo);
        }
       /* for(int i=0; i<cantidadEnemigos;i++){
            enemigo = new Rectangle(20,20);
            enemigo.setTranslateX((int) Math.floor(Math.random() * -200 +200));
            enemigo.setTranslateY((int) Math.floor(Math.random() * 200 -200));

            enemigo.setStyle("-fx-fill: url(https://w7.pngwing.com/pngs/187/1011/png-transparent-space-invaders-arcade-game-video-game-gamenight-game-angle-text-thumbnail.png)");
            //moverEnemigo();

            pista.getChildren().add(enemigo);
        }*/
    }
}
