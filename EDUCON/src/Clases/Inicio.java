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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Inicio extends Application {
   
    @Override
    public void start(Stage primaryStage) {
       
        Button btn = new Button("Inicio");
        btn.setOnAction(event -> System.out.println("Hello MUNDO!"));
       
        Button btn2 = new Button("Opciones");
        btn2.setOnAction(event -> System.out.println("Hello World!"));
        
        Button btn3 = new Button("Salir");
        btn3.setOnAction(event -> {
                Stage stage = (Stage)
        btn3.getScene().getWindow();
                stage.close();
                
        });
        
        
       
        String estiloboton = "-fx-font-size: 29px; -fx-background-radius: 30; -fx-background-color: #0071E3; -fx-text-fill: white;";
        String estiloboton2 = "-fx-font-size: 29px; -fx-background-radius: 30; -fx-background-color: #07E095; -fx-text-fill: white;";
        String estiloboton3 = "-fx-font-size: 29px; -fx-background-radius: 30; -fx-background-color: #E07504; -fx-text-fill: white;";
       //
        btn.setStyle(estiloboton);
        btn2.setStyle(estiloboton2);
        btn3.setStyle(estiloboton3);
       
        VBox root = new VBox(20); // 20px de espacio entre botones
        root.getChildren().addAll(btn, btn2, btn3);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #F296BC, #E070A9);");
        root.setAlignment(javafx.geometry.Pos.CENTER); // centra los botones en pantalla
       
        Scene scene = new Scene(root, 900, 650);
        primaryStage.setTitle("Menú Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}