/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AI8Puzzle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameEngine gameEngine = GameEngine.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("GUI/main.fxml"));
        Scene scene = new Scene(root);//, 500, 500);
        primaryStage.setTitle("8 Puzzle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    
    public static void main(String[] args) {

        launch(args);


    }

}

