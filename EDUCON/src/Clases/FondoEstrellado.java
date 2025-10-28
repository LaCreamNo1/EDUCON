/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author bebed
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FondoEstrellado extends Pane {

    private static final int NUM_ESTRELLAS = 20;
    private double[] x = new double[NUM_ESTRELLAS];
    private double[] y = new double[NUM_ESTRELLAS];
    private double[] dx = new double[NUM_ESTRELLAS];
    private double[] dy = new double[NUM_ESTRELLAS];
    private Canvas canvas;

    public FondoEstrellado(double width, double height) {
        canvas = new Canvas(width, height);
        getChildren().add(canvas);
        inicializarEstrellas();
        animar();
    }

    private void inicializarEstrellas() {
        for (int i = 0; i < NUM_ESTRELLAS; i++) {
            x[i] = Math.random() * canvas.getWidth();
            y[i] = Math.random() * canvas.getHeight();
            dx[i] = (Math.random() - 0.5) * 0.5;
            dy[i] = (Math.random() - 0.5) * 0.5;
        }
    }

    private void animar() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline animacion = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            gc.setFill(Color.web("#0B0C2A"));
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            gc.setFill(Color.WHITE);
            for (int i = 0; i < NUM_ESTRELLAS; i++) {
                x[i] += dx[i];
                y[i] += dy[i];

                if (x[i] < 0 || x[i] > canvas.getWidth()) dx[i] *= -1;
                if (y[i] < 0 || y[i] > canvas.getHeight()) dy[i] *= -1;

                gc.fillOval(x[i], y[i], 3, 3);
            }
        }));
        animacion.setCycleCount(Timeline.INDEFINITE);
        animacion.play();
    }
}