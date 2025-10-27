/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author DELL
 */
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Matematicas {

    private TextField pantalla; // mostrará las operaciones
    private String operador = "";
    private int numero1 = 0;
    private boolean nuevaOperacion = true;

    public void mostrar(Stage stage) {

        // Panel derecho (calculadora)
        pantalla = new TextField();
        pantalla.setEditable(false);
        pantalla.setStyle("-fx-font-size: 24px; -fx-background-color: white; -fx-text-fill: black;");
        pantalla.setPrefHeight(60);

        GridPane panelNumeros = new GridPane();
        panelNumeros.setHgap(10);
        panelNumeros.setVgap(10);
        panelNumeros.setAlignment(Pos.CENTER);
        panelNumeros.setPadding(new Insets(10));

        // Botones de números
        int num = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button b = new Button(String.valueOf(num));
                b.setPrefSize(60, 60);
                b.setStyle("-fx-font-size: 22px; -fx-background-color: #07E095; -fx-text-fill: white; -fx-background-radius: 15;");
                final int n = num;
                b.setOnAction(e -> {
                    if (nuevaOperacion) {
                        pantalla.clear();
                        nuevaOperacion = false;
                    }
                    pantalla.appendText(String.valueOf(n));
                });
                panelNumeros.add(b, j, i);
                num++;
            }
        }

        // Botón cero
        Button b0 = new Button("0");
        b0.setPrefSize(60, 60);
        b0.setStyle("-fx-font-size: 22px; -fx-background-color: #07E095; -fx-text-fill: white; -fx-background-radius: 15;");
        b0.setOnAction(e -> pantalla.appendText("0"));
        panelNumeros.add(b0, 1, 3);

        // Botones de operaciones básicas
        Button suma = new Button("+");
        Button resta = new Button("-");
        Button multi = new Button("×");
        Button divi = new Button("÷");
        Button igual = new Button("=");
        Button limpiar = new Button("C");

        Button[] operaciones = {suma, resta, multi, divi, igual, limpiar};
        for (Button b : operaciones) {
            b.setPrefSize(60, 60);
            b.setStyle("-fx-font-size: 22px; -fx-background-color: #0071E3; -fx-text-fill: white; -fx-background-radius: 15;");
        }

        suma.setOnAction(e -> establecerOperacion("+"));
        resta.setOnAction(e -> establecerOperacion("-"));
        multi.setOnAction(e -> establecerOperacion("*"));
        divi.setOnAction(e -> establecerOperacion("/"));

        igual.setOnAction(e -> calcularResultado());
        limpiar.setOnAction(e -> pantalla.clear());

        VBox panelOperaciones = new VBox(10, suma, resta, multi, divi, igual, limpiar);
        panelOperaciones.setAlignment(Pos.CENTER);

        // Panel de fracciones (propias/impropias)
        Button fraccion = new Button("Fracción");
        fraccion.setStyle("-fx-font-size: 22px; -fx-background-color: #E07504; -fx-text-fill: white; -fx-background-radius: 15;");
        fraccion.setPrefWidth(140);
        fraccion.setOnAction(e -> verificarFraccion());

        // Panel izquierdo con operaciones
        VBox panelIzquierdo = new VBox(25,
                new Label("Operaciones Básicas:"), panelOperaciones, fraccion);
        panelIzquierdo.setAlignment(Pos.CENTER);
        panelIzquierdo.setPadding(new Insets(20));

        // Panel derecho (mini calculadora)
        VBox panelDerecho = new VBox(20, pantalla, panelNumeros);
        panelDerecho.setAlignment(Pos.CENTER);
        panelDerecho.setPadding(new Insets(20));

        // Botón volver
        Button volver = new Button("Volver");
        volver.setStyle("-fx-font-size: 22px; -fx-background-radius: 30; -fx-background-color: #9B4DCA; -fx-text-fill: white;");
        volver.setOnAction(e -> {
            pantalla.clear();
            MenuOpciones menu = new MenuOpciones();
            menu.mostrar(stage);
        });

        HBox contenedorPrincipal = new HBox(40, panelIzquierdo, panelDerecho);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setStyle("-fx-background-color: linear-gradient(to bottom, #F296BC, #E070A9);");

        VBox root = new VBox(30, contenedorPrincipal, volver);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 900, 650);
        stage.setTitle("Matemáticas");
        stage.setScene(scene);
        stage.show();
    }

    private void establecerOperacion(String op) {
        try {
            numero1 = Integer.parseInt(pantalla.getText());
            operador = op;
            pantalla.clear();
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }

    private void calcularResultado() {
        try {
            int numero2 = Integer.parseInt(pantalla.getText());
            int resultado = 0;

            switch (operador) {
                case "+" -> resultado = numero1 + numero2;
                case "-" -> resultado = numero1 - numero2;
                case "*" -> resultado = numero1 * numero2;
                case "/" -> {
                    if (numero2 == 0) {
                        pantalla.setText("Error /0");
                        return;
                    }
                    resultado = numero1 / numero2;
                }
                default -> pantalla.setText("?");
            }
            pantalla.setText(String.valueOf(resultado));
            nuevaOperacion = true;
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }

    private void verificarFraccion() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Verificar Fracción");
        dialog.setHeaderText("Ingresa el numerador y denominador separados por '/'");
        dialog.setContentText("Ejemplo: 3/4");

        dialog.showAndWait().ifPresent(input -> {
            try {
                String[] partes = input.split("/");
                int num = Integer.parseInt(partes[0]);
                int den = Integer.parseInt(partes[1]);

                if (den == 0) {
                    pantalla.setText("Error: Denominador 0");
                    return;
                }

                if (Math.abs(num) < Math.abs(den)) {
                    pantalla.setText(num + "/" + den + " es propia");
                } else {
                    pantalla.setText(num + "/" + den + " es impropia");
                }

            } catch (Exception e) {
                pantalla.setText("Formato inválido");
            }
        });
    }
}

