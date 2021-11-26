package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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

    private Enemigos enem;

    private Label score= new Label();
    private long puntuacion=100;



//Configurar rutas para multiplataforma
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
        crearMarcador();

    }

    private void inicializarControles() {
        pista.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case SPACE:
                    enem= new Enemigos(paredIzquierda, paredArriba, paredDerecha, paredAbajo, tanque, pista);
                    animacion.play();
                    desplY=0;
                    desplX=0;
                    cancion.play();
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

            //moverEnemigo();
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
    private void crearMarcador(){

        score.setText("SCORE: "+puntuacion);
        score.setTextFill(Color.WHITE);
        score.setFont(new Font("Bauhaus 93",25));
        score.setPrefSize(500,500);
        score.setAlignment(Pos.BOTTOM_CENTER);
        score.setPadding(new Insets(0,0,20,275));

        pista.getChildren().addAll(score);

    }

}
