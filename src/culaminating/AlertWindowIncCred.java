/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Usman MLG
 */
public class AlertWindowIncCred  {
    public static void display(String title,String message)
    {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setVgap(10);
    grid.setHgap(10);
    grid.setAlignment(Pos.CENTER);
    
    Label prompt = new Label(message);
    GridPane.setConstraints(prompt, 0, 0);
    
    Button exitBtn = new Button();
    exitBtn.setText("Ok");
    exitBtn.setOnAction(e -> window.close());
    GridPane.setConstraints(exitBtn, 0, 1);
    
    grid.getChildren().addAll(prompt,exitBtn);
        Scene errorScene = new Scene(grid,300,100);
    
    window.setScene(errorScene);
    window.showAndWait();
    
    }
}
