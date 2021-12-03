package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Enemigos {

    private StackPane pista;
    private Rectangle paredIzquierda;
    private Rectangle paredArriba;
    private Rectangle paredDerecha;
    private Rectangle paredAbajo;

    private Rectangle tanque;

    private Rectangle bala;

    private double eneX;
    private double eneY;

    private double velocidad;
    private Timeline animacionEnemigos;

    private JuegoController v;

    private Rectangle enemigo;
    List<Rectangle> listaEnemigos = new ArrayList<>();

    private Label score= new Label();
    private IntegerProperty puntuacion;

    AudioClip matarEnemigo = new AudioClip("file:///C:/Users/danie/Downloads/000961870_prev.mp3");


    public Enemigos(Rectangle paredIzquierda, Rectangle paredArriba, Rectangle paredDerecha,
                    Rectangle paredAbajo, Rectangle tanque, StackPane pista,Rectangle bala) {
        this.pista = pista;
        this.paredIzquierda = paredIzquierda;
        this.paredArriba = paredArriba;
        this.paredDerecha = paredDerecha;
        this.paredAbajo = paredAbajo;
        this.tanque = tanque;
        this.bala= bala;
        this.velocidad = 1.5;
        this.eneX=1;
        this.eneY=1;
        this.puntuacion= new SimpleIntegerProperty(0);
        score.textProperty().bind(puntuacion.asString("Score: %d"));

        inicializarEnemigos();
        crearEnemigos();
        crearMarcador();

    }

    public Enemigos() {
    }

    private void inicializarEnemigos() {
        this.animacionEnemigos = new Timeline(new KeyFrame(Duration.millis(17), t -> {

            moverEnemigo();
            detectarColision();

        }));
        animacionEnemigos.setCycleCount(Animation.INDEFINITE);
        animacionEnemigos.play();
    }

    private List<Rectangle> crearEnemigos() {

        while (listaEnemigos.size() < 5) {

            enemigo = new Rectangle(20, 20);
            //CREAR CONDICION PARA POSICIONES
            enemigo.setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            enemigo.setTranslateY((int) Math.floor(Math.random() * 200 - 200));

            enemigo.setFill(new ImagePattern(new Image("enemigo.png")));

            pista.getChildren().add(enemigo);

            listaEnemigos.add(enemigo);
        }
        return listaEnemigos;
    }

    private void detectarColision() {
        //toque con bala
        listaEnemigos.forEach(enemigo->{
            if (bala.getBoundsInParent().intersects(enemigo.getBoundsInParent())) {
                enemigo.setTranslateY((int) Math.floor(Math.random() * 200 - 200));
                enemigo.setTranslateX((int) Math.floor(Math.random() * 200 - 200));
                puntuacion.set(puntuacion.get()+100);
                matarEnemigo.play();
            }
        });
       //toque con la nave
        listaEnemigos.forEach(enemigo->{
            if (tanque.getBoundsInParent().intersects(enemigo.getBoundsInParent())) {
                enemigo.setTranslateY((int) Math.floor(Math.random() * 200 - 200));
                enemigo.setTranslateX((int) Math.floor(Math.random() * 200 - 200));
                puntuacion.set(puntuacion.get()-100);

            }
        });

        //pared derecha
        if (listaEnemigos.get(0).getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            eneX = -1;
        }
        if (listaEnemigos.get(1).getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            eneX = -1;
        }
        if (listaEnemigos.get(2).getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            eneX = -1;
        }
        if (listaEnemigos.get(3).getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            eneX = -1;
        }
        if (listaEnemigos.get(4).getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            eneX = -1;
        }
        //pared izquierda
        if (listaEnemigos.get(0).getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())) {
            eneX = 1;
        }
        if (listaEnemigos.get(1).getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())) {
            eneX = 1;
        }
        if (listaEnemigos.get(2).getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())) {
            eneX = 1;
        }
        if (listaEnemigos.get(3).getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())) {
            eneX = 1;
        }
        if (listaEnemigos.get(4).getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())) {
            eneX = 1;
        }
    }

    private void moverEnemigo() {

        listaEnemigos.forEach(enemigo->{
            enemigo.setTranslateX(enemigo.getTranslateX()+eneX*velocidad);
        });

    }
    private void crearMarcador(){

        score.setTextFill(Color.WHITE);
        score.setFont(new Font("Bauhaus 93",25));
        score.setPrefSize(500,500);
        score.setAlignment(Pos.BOTTOM_CENTER);
        score.setPadding(new Insets(0,0,20,275));

        pista.getChildren().addAll(score);
    }


}
