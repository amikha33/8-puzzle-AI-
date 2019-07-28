package Controller;

import Algorithm_Model.Algorithm;
import Algorithm_Model.*;
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



    //Controller.GameEngine gameEngine = Controller.GameEngine.getInstance();
    Algorithm myAlgorithm;
    @Override
    public void initialize(URL url, ResourceBundle rb){
//         = new BFS();
//        int [] arr = {1,2,5,3,4,0,6,7,8};
//        int [] arr2 = {1,2,3,4,5,6,7,0,8};
//
//        myAlgorithm.search(arr,null);

    }

    @FXML
    private TextField inputState;

    @FXML
    private ComboBox<?> algorithmSelector;

    @FXML
    private ComboBox<?> heuristicSelector;

    @FXML
    private ListView<?> outputList;

    @FXML
    void SelectHeuristic(ActionEvent event) {

    }

    @FXML
    void generateBoard(ActionEvent event) {

    }

    @FXML
    void selectAlgorithm(ActionEvent event) {

    }

    @FXML
    void solve(ActionEvent event) {
        myAlgorithm= new BFS();
        int [] arr = {1,2,5,3,4,0,6,7,8};
        ArrayList<Node>Path = myAlgorithm.search(arr,null);
        for (Node i:
             Path) {
            System.out.println(i.getState()[0]+" "+i.getState()[1]+" "+i.getState()[2]+"\n"+
                    i.getState()[3]+" "+i.getState()[4]+" "+i.getState()[5]+"\n"+
                    i.getState()[6]+" "+i.getState()[7]+" "+i.getState()[8]+"\n"
            );
            System.out.println(i.getDepth());
        }
    }
}
