package Controller;

import Algorithm_Model.Algorithm;
import Algorithm_Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private TextField inputState;

    @FXML
    private ComboBox<String> algorithmSelector;

    @FXML
    private ComboBox<String> heuristicSelector;

    @FXML
    private ListView<String> outputList;

    @FXML
    private ListView<String> exploredList;


    //Controller.GameEngine gameEngine = Controller.GameEngine.getInstance();
    Algorithm myAlgorithm;
    Heuristic myHeuristic;
    @Override
    public void initialize(URL url, ResourceBundle rb){
//         = new BFS();
//        int [] arr = {1,2,5,3,4,0,6,7,8};
//        int [] arr2 = {1,2,3,4,5,6,7,0,8};
//
//        myAlgorithm.search(arr,null);
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "A*",
                        "BFS",
                        "DFS"
                );
        algorithmSelector.setItems(options);
        ObservableList<String> heuristic =
                FXCollections.observableArrayList(
                        "Manhattan",
                        "Euclidean"
                );

        heuristicSelector.setItems(heuristic);
    }

    @FXML
    void SelectHeuristic(ActionEvent event) {
        if (heuristicSelector.getValue().equalsIgnoreCase("Manhattan")) {
            myAlgorithm = new A_Star(new Manhattan());
        }else if(heuristicSelector.getValue().equalsIgnoreCase("Euclidean")){
            myAlgorithm = new A_Star(new Euclidean());
        }

    }

    @FXML
    void generateBoard(ActionEvent event) {

    }

    @FXML
    void selectAlgorithm(ActionEvent event) {
        System.out.println("here");
            if (algorithmSelector.getValue().equalsIgnoreCase("BFS")) {
                myAlgorithm = new BFS();
                System.out.println("Bfs it is");
            }
            else if (algorithmSelector.getValue().equalsIgnoreCase("DFS")) {
                myAlgorithm = new DFS();
            }
            else{
                myAlgorithm = new A_Star(new Manhattan());
                heuristicSelector.setValue("Manhattan");
                System.out.println("A* selected" );
            }
    }

    @FXML
    void solve(ActionEvent event) {
        //myAlgorithm= new BFS();
        outputList.getItems().clear();
        String test = inputState.getText();
        String[] integerStrings = test.split(" ");
        int[] arr = new int[integerStrings.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(integerStrings[i]);
        }
        ArrayList<Node>Path = myAlgorithm.search(arr,null);
        System.out.println("path is "+Path.size());
        for (Node i:
             Path) {
            System.out.println("Depth is " + i.getDepth());
            if (myAlgorithm instanceof A_Star){
                Heuristic myHeuristic =((A_Star) myAlgorithm).getHeuristicType();

                System.out.println("Heuristic is " + myHeuristic.getHeuristic(i.getState()));

            }
            System.out.println(i.getState()[0]+" "+i.getState()[1]+" "+i.getState()[2]+"\n"+
                    i.getState()[3]+" "+i.getState()[4]+" "+i.getState()[5]+"\n"+
                    i.getState()[6]+" "+i.getState()[7]+" "+i.getState()[8]+"\n"
            );
            if (myAlgorithm instanceof A_Star){
                myHeuristic =((A_Star) myAlgorithm).getHeuristicType();

                outputList.getItems().add(
                        "Heuristic is " + myHeuristic.getHeuristic(i.getState())+"\n"+
                                "Depth is " + i.getDepth()+"\n"+i.getState()[0]+" "+i.getState()[1]+" "+i.getState()[2]+"\n"+
                                i.getState()[3]+" "+i.getState()[4]+" "+i.getState()[5]+"\n"+
                                i.getState()[6]+" "+i.getState()[7]+" "+i.getState()[8]+"\n");
            }else {
            outputList.getItems().add(
                            "Depth is " + i.getDepth()+"\n"+i.getState()[0]+" "+i.getState()[1]+" "+i.getState()[2]+"\n"+
                            i.getState()[3]+" "+i.getState()[4]+" "+i.getState()[5]+"\n"+
                            i.getState()[6]+" "+i.getState()[7]+" "+i.getState()[8]+"\n");
               }
            }

        outputList.getItems().add("Reached Goal");
    }
}
