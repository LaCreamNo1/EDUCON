/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author DELL
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Español {

    public void mostrar(Stage stage) {

        // Carga una imagen (debe estar en la carpeta del proyecto o en resources)
        Image imagen = new Image("Imagenes/img2_2.png"); 
        ImageView vista = new ImageView(imagen);
        vista.setFitWidth(400);
        vista.setPreserveRatio(true);

        // Botón Volver
        Button volver = new Button("Volver");
        volver.setStyle("-fx-font-size: 22px; -fx-background-radius: 30; -fx-background-color: #9B4DCA; -fx-text-fill: white;");
        volver.setOnAction(e -> {
            MenuOpciones menu = new MenuOpciones();
            menu.mostrar(stage);
        });

        // Contenedor principal
        VBox root = new VBox(40, vista, volver);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #F296BC, #E070A9);");

        Scene scene = new Scene(root, 900, 650);
        stage.setTitle("Español");
        stage.setScene(scene);
        stage.show();
    }
}

