/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author DELL
 */
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuOpciones {

    public void mostrar(Stage stage) {

        Button btn1 = new Button("Matemáticas");
        Button btn2 = new Button("Geometría");
        Button btn3 = new Button("Inglés");
        Button btn4 = new Button("Español");
        Button btnVolver = new Button("Volver");

        // Estiloslos del menú principal
        String estilo1 = "-fx-font-size: 29px; -fx-background-radius: 30; -fx-background-color: #0071E3; -fx-text-fill: white;";
        String estilo2 = "-fx-font-size: 29px; -fx-background-radius: 30; -fx-background-color: #07E095; -fx-text-fill: white;";
        String estilo3 = "-fx-font-size: 29px; -fx-background-radius: 30; -fx-background-color: #E07504; -fx-text-fill: white;";
        String estiloVolver = "-fx-font-size: 25px; -fx-background-radius: 30; -fx-background-color: #9B4DCA; -fx-text-fill: white;";

        btn1.setStyle(estilo1);
        btn2.setStyle(estilo2);
        btn3.setStyle(estilo3);
        btn4.setStyle(estilo1);
        btnVolver.setStyle(estiloVolver);

        
        // Acción del botón Volver 
        btnVolver.setOnAction(e -> {
            Inicio inicio = new Inicio();
            try {
                inicio.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        btn1.setOnAction(e -> {
         Matematicas m = new Matematicas();
          m.mostrar(stage);
        });


        VBox root = new VBox(20);
        root.getChildren().addAll(btn1, btn2, btn3, btn4, btnVolver);
        root.setAlignment(javafx.geometry.Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #F296BC, #E070A9);");

        Scene scene = new Scene(root, 900, 650);
        stage.setTitle("Selecciona una opción");
        stage.setScene(scene);
        stage.show();
    }
}

