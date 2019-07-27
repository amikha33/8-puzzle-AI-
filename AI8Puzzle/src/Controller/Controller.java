package Controller;

import Algorithm_Model.Algorithm;
import Algorithm_Model.BFS;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    //Controller.GameEngine gameEngine = Controller.GameEngine.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        Algorithm myAlgorithm = new BFS();
        int [] arr = {1,0,2,3,4,5,6,7,8};
        int [] arr2 = {1,2,3,4,5,6,7,0,8};

        myAlgorithm.search(arr,null);

    }
}
