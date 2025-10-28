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
import javafx.scene.layout.StackPane;
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
        String estilo1 = "-fx-font-size: 29px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #2E003E, #4B0082); "
                + "-fx-text-fill: #C0F8FF; "
                + "-fx-effect: dropshadow(gaussian, #8A2BE2, 10, 0.5, 0, 0);";

        String estilo2 = "-fx-font-size: 29px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #001F3F, #0074D9); "
                + "-fx-text-fill: #FFFFFF; "
                + "-fx-effect: dropshadow(gaussian, #00FFFF, 8, 0.4, 0, 0);";

        String estilo3 = "-fx-font-size: 29px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #3D0C02, #8B0000); "
                + "-fx-text-fill: #FFD700; "
                + "-fx-effect: dropshadow(gaussian, #FF4500, 12, 0.6, 0, 0);";

        String estiloVolver = "-fx-font-size: 25px; "
                + "-fx-background-radius: 30; "
                + "-fx-background-color: linear-gradient(to bottom, #4B0082, #9B4DCA); "
                + "-fx-text-fill: #E0E0FF; "
                + "-fx-effect: dropshadow(gaussian, #BA55D3, 10, 0.5, 0, 0);";

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
        
        btn4.setOnAction(e -> {
         Español esp = new Español();
         esp.mostrar(stage);
        });

        
        btn1.setOnAction(e -> {
         Matematicas m = new Matematicas();
          m.mostrar(stage);
        });
        
        // Contenedor de botones
        VBox botones = new VBox(20, btn1, btn2, btn3, btn4, btnVolver);
botones.setAlignment(javafx.geometry.Pos.CENTER);

// Fondo estrellado animado
FondoEstrellado fondo = new FondoEstrellado(900, 650);

// Superponer fondo y botones organizados
StackPane root = new StackPane(fondo, botones);
root.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, 900, 650);
        stage.setTitle("Selecciona una opción");
        stage.setScene(scene);
        stage.show();
    }
}

