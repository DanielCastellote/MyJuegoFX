package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
    private long puntuacion=0;

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



        inicializarEnemigos();
        crearEnemigos();
        //crearMarcador();

    }

    public Enemigos() {
    }

    private void inicializarEnemigos() {
        this.animacionEnemigos = new Timeline(new KeyFrame(Duration.millis(17), t -> {

            moverEnemigo();
            detectarColision();
            crearMarcador();


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
        if (bala.getBoundsInParent().intersects(listaEnemigos.get(0).getBoundsInParent())) {
            listaEnemigos.get(0).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(0).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion+100);
            matarEnemigo.play();
        }
        if (bala.getBoundsInParent().intersects(listaEnemigos.get(1).getBoundsInParent())) {
            listaEnemigos.get(1).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(1).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion+100);
            matarEnemigo.play();
        }
        if (bala.getBoundsInParent().intersects(listaEnemigos.get(2).getBoundsInParent())) {
            listaEnemigos.get(2).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(2).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion+100);
            matarEnemigo.play();
        }
        if (bala.getBoundsInParent().intersects(listaEnemigos.get(3).getBoundsInParent())) {
            listaEnemigos.get(3).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(3).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion+100);
            matarEnemigo.play();
        }
        if (bala.getBoundsInParent().intersects(listaEnemigos.get(4).getBoundsInParent())) {
            listaEnemigos.get(4).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(4).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion+100);
            matarEnemigo.play();
        }
        //toque con el tanque
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(0).getBoundsInParent())) {
            listaEnemigos.get(0).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(0).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion-100);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(1).getBoundsInParent())) {
            listaEnemigos.get(1).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(1).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion-100);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(2).getBoundsInParent())) {
            listaEnemigos.get(2).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(2).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion-100);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(3).getBoundsInParent())) {
            listaEnemigos.get(3).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(3).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion-100);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(4).getBoundsInParent())) {
            listaEnemigos.get(4).setTranslateY((int) Math.floor(Math.random() * 200 - 200));
            listaEnemigos.get(4).setTranslateX((int) Math.floor(Math.random() * 200 - 200));
            setPuntuacion(puntuacion-100);
        }
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
        listaEnemigos.get(1).setTranslateX(listaEnemigos.get(1).getTranslateX()+eneX*velocidad);
        listaEnemigos.get(2).setTranslateX(listaEnemigos.get(2).getTranslateX()+eneX*velocidad);
        listaEnemigos.get(3).setTranslateX(listaEnemigos.get(3).getTranslateX()+eneX*velocidad);
        listaEnemigos.get(4).setTranslateX(listaEnemigos.get(4).getTranslateX()+eneX*velocidad);
        listaEnemigos.get(0).setTranslateX(listaEnemigos.get(0).getTranslateX()+eneX*velocidad);

    }
    private void crearMarcador(){

        score.setText("SCORE: "+getPuntuacion());
        score.setTextFill(Color.WHITE);
        score.setFont(new Font("Bauhaus 93",25));
        score.setPrefSize(500,500);
        score.setAlignment(Pos.BOTTOM_CENTER);
        score.setPadding(new Insets(0,0,20,275));

        pista.getChildren().addAll(score);
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }
}
