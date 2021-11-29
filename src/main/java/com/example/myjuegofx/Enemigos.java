package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
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

    private double eneX;
    private double eneY;

    private double velocidad;
    private Timeline animacionEnemigos;

    private JuegoController v;

    private Rectangle enemigo;
    List<Rectangle> listaEnemigos = new ArrayList<>();

    private Label score= new Label();
    private long puntuacion=0;



    public Enemigos(Rectangle paredIzquierda, Rectangle paredArriba, Rectangle paredDerecha,
                    Rectangle paredAbajo, Rectangle tanque, StackPane pista) {
        this.pista = pista;
        this.paredIzquierda = paredIzquierda;
        this.paredArriba = paredArriba;
        this.paredDerecha = paredDerecha;
        this.paredAbajo = paredAbajo;
        this.tanque = tanque;
        this.velocidad = 1.5;
        this.eneX=1;
        this.eneY=1;


        crearMarcador();
        inicializarEnemigos();
        crearEnemigos();

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
        //toque con el tanque
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(0).getBoundsInParent())) {
            listaEnemigos.get(0).setVisible(false);
            setPuntuacion(puntuacion+100);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(1).getBoundsInParent())) {
            listaEnemigos.get(1).setVisible(false);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(2).getBoundsInParent())) {
            listaEnemigos.get(2).setVisible(false);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(3).getBoundsInParent())) {
            listaEnemigos.get(3).setVisible(false);
        }
        if (tanque.getBoundsInParent().intersects(listaEnemigos.get(4).getBoundsInParent())) {
            listaEnemigos.get(4).setVisible(false);
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
