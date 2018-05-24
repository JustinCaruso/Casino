/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package culaminating;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginFormFX extends Application {

    Stage window;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        LogClass a = new LogClass();
        a.OpenFile();
        a.AddLog("20 ", "Justin ", "Caruso \n");

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        LogClass a = new LogClass();

        window = primaryStage;
        window.setTitle("Casino");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 1);
        //Welcome Label
        Label welcomeLbl = new Label("Welcome");
        GridPane.setConstraints(welcomeLbl, 0, 0);
        welcomeLbl.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        //Name Input
        TextField nameInput = new TextField("Username");
        GridPane.setConstraints(nameInput, 1, 1);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);

        //Password Input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 2);

        //Login
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 3);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, welcomeLbl);
        //Event handler
        loginButton.setOnAction(e -> {

            try {
                System.out.println(
                        a.ReadFile((nameInput.getText()), (passInput.getText())));
            } catch (IOException ex) {
                Logger.getLogger(LoginFormFX.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        Scene scene = new Scene(grid, 800, 600);
        window.setScene(scene);
        window.show();
    }

}
