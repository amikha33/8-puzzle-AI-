//package GUI;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algorithm_Model.*;
import Controller.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class AI8Puzzle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //   GameEngine gameEngine = GameEngine.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("GUI/main.fxml"));
        Scene scene = new Scene(root);//, 500, 500);
        primaryStage.setTitle("8 Puzzle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        /**Algorithm algorithm = new A_Star(new Manhattan());
        int[] x = {1, 2, 0, 3, 4, 5, 6, 7, 8};
        ArrayList<Node> path = algorithm.search(x, null);

        for (Node node : path) {
            System.out.println(node.getState()[0] + " " + node.getState()[1] + " " + node.getState()[2]);
            System.out.println(node.getState()[3] + " " + node.getState()[4] + " " + node.getState()[5]);
            System.out.println(node.getState()[6] + " " + node.getState()[7] + " " + node.getState()[8]);
            System.out.println();
            System.out.println();
            System.out.println();

        }
         Stack<Node> stack = new Stack<>();
         System.out.println("Max Depth: " + algorithm.getMaxDepth(stack,new int[]{0,1,2,3,4,5,6,7,8}) + "      path cost: "+algorithm.getCostPath()+"      number of explored nodes: " + algorithm.getExploredNoOfNodes(stack));
         **/

    }

}

