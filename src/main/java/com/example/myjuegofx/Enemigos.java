package com.example.myjuegofx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Enemigos {

    private double eneX=1;
    private double eneY;

    private double velocidad;
    private Timeline animacion;

    private Rectangle enemigo;
    List<Rectangle> listaEnemigos= new ArrayList<>();

    public Enemigos() {

        this.velocidad = 1.5;
        this.listaEnemigos = listaEnemigos;

        crearEnemigos();
        inicializarEnemigos();
    }

    private void inicializarEnemigos() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {

            moverEnemigo();
        }));

        animacion.setCycleCount(Animation.INDEFINITE);
    }

    private void crearEnemigos(){

        while(listaEnemigos.size()<=5){

            enemigo = new Rectangle(20,20);

            listaEnemigos.add(enemigo);
        }


    }
    private void moverEnemigo(){


        while(listaEnemigos.size()!=0){

            listaEnemigos.stream().findFirst().get().setTranslateX(listaEnemigos.stream().findFirst().get().getTranslateX()+eneX*velocidad);
        }
    }

}
