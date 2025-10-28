/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import static javafx.application.Application.launch;


/**
 *
 * @author bebed
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Inicio extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Botones
        Button btn = new Button("Inicio");
        btn.setOnAction(event -> {
            MenuOpciones menu = new MenuOpciones();
            menu.mostrar(primaryStage);
        });

        Button btn2 = new Button("Opciones");
        btn2.setOnAction(event -> System.out.println("Has presionado Opciones"));

        Button btn3 = new Button("Salir");
        btn3.setOnAction(event -> {
            Stage stage = (Stage) btn3.getScene().getWindow();
            stage.close();
        });

        // Estilos galácticos
        String estiloboton = "-fx-font-size: 29px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #2E003E, #4B0082); "
                + "-fx-text-fill: #C0F8FF; "
                + "-fx-effect: dropshadow(gaussian, #8A2BE2, 10, 0.5, 0, 0);";

        String estiloboton2 = "-fx-font-size: 29px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #001F3F, #0074D9); "
                + "-fx-text-fill: #FFFFFF; "
                + "-fx-effect: dropshadow(gaussian, #00FFFF, 8, 0.4, 0, 0);";

        String estiloboton3 = "-fx-font-size: 29px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #3D0C02, #8B0000); "
                + "-fx-text-fill: #FFD700; "
                + "-fx-effect: dropshadow(gaussian, #FF4500, 12, 0.6, 0, 0);";

        btn.setStyle(estiloboton);
        btn2.setStyle(estiloboton2);
        btn3.setStyle(estiloboton3);

        // Contenedor de botones
        VBox botones = new VBox(20, btn, btn2, btn3);
        botones.setAlignment(javafx.geometry.Pos.CENTER);

        // Fondo estrellado animado
        FondoEstrellado fondo = new FondoEstrellado(900, 650);

        // Superponer fondo y botones
        StackPane root = new StackPane(fondo, botones);

        Scene scene = new Scene(root, 900, 650);
        primaryStage.setTitle("Menú Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}