package Controller;

import Algorithm_Model.Algorithm;
import Algorithm_Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<?> ref;

    @FXML
    private ImageView zero;

    @FXML
    private ImageView one;

    @FXML
    private ImageView two;

    @FXML
    private ImageView three;

    @FXML
    private ImageView four;

    @FXML
    private ImageView five;

    @FXML
    private ImageView six;

    @FXML
    private ImageView seven;

    @FXML
    private ImageView eight;
    @FXML
    private ImageView zero1;

    @FXML
    private ImageView one1;

    @FXML
    private ImageView two1;

    @FXML
    private ImageView three1;

    @FXML
    private ImageView four1;

    @FXML
    private ImageView five1;

    @FXML
    private ImageView six1;

    @FXML
    private ImageView seven1;

    @FXML
    private ImageView eight1;

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
    @FXML
    private Label depthLabel;

    @FXML
    private Label pathCost;

    @FXML
    private Label runtime;

    //Controller.GameEngine gameEngine = Controller.GameEngine.getInstance();
    Algorithm myAlgorithm;
    Heuristic myHeuristic;
    ArrayList<Node>Path;
    int count = 0;

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

//        one.setLayoutX(eight1.getLayoutX());
//        one.setLayoutY(eight1.getLayoutY());

        algorithmSelector.setItems(options);
        algorithmSelector.setValue("BFS");
        myAlgorithm = new BFS();
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
            inputState.setText("");
    }


    void move(int[] state){
        int x = 0;
        int y = 0;
        for (int i = 0; i <9 ; i++) {
            ImageView myImageView = null;
            switch (state[i]){
                case 0:
                    myImageView = zero;
                    break;
                case 1:
                    myImageView = one;
                    break;
                case 2:
                    myImageView = two;
                    break;
                case 3:
                    myImageView = three;
                    break;
                case 4:
                    myImageView = four;
                    break;
                case 5:
                    myImageView = five;
                    break;
                case 6:
                    myImageView = six;
                    break;
                case 7:
                    myImageView = seven;
                    break;
                case 8:
                    myImageView = eight;
                    break;
                 default:
                     System.out.println("Switch case failed");
                    break;
            }
            myImageView.setLayoutX(ref.getLayoutX() +15+ x * 60);
            myImageView.setLayoutY(ref.getLayoutY()+25+ y * 50);
            x++;
            if (x>2){
                y++;
                x =0;
            }
        }
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
        count = 0;
        long startTime = System.currentTimeMillis();

        //myAlgorithm= new BFS();
        outputList.getItems().clear();
        String test = inputState.getText();
        String[] integerStrings = test.split(" ");
        int[] arr = new int[integerStrings.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(integerStrings[i]);
        }
        Path = myAlgorithm.search(arr,null);
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

        exploredList.getItems().clear();
        for (Node i:
             myAlgorithm.getExplored()) {
            if (myAlgorithm instanceof A_Star){
                myHeuristic =((A_Star) myAlgorithm).getHeuristicType();

                exploredList.getItems().add(
                        "Heuristic is " + myHeuristic.getHeuristic(i.getState())+"\n"+
                                "Depth is " + i.getDepth()+"\n"+i.getState()[0]+" "+i.getState()[1]+" "+i.getState()[2]+"\n"+
                                i.getState()[3]+" "+i.getState()[4]+" "+i.getState()[5]+"\n"+
                                i.getState()[6]+" "+i.getState()[7]+" "+i.getState()[8]+"\n");
            }else {
                exploredList.getItems().add(
                        "Depth is " + i.getDepth()+"\n"+i.getState()[0]+" "+i.getState()[1]+" "+i.getState()[2]+"\n"+
                                i.getState()[3]+" "+i.getState()[4]+" "+i.getState()[5]+"\n"+
                                i.getState()[6]+" "+i.getState()[7]+" "+i.getState()[8]+"\n");
            }
        }

        depthLabel.setText(Integer.toString( myAlgorithm.getSearchDepth()));
        pathCost.setText(Integer.toString( myAlgorithm.getCostPath()));

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Elapsed time is " + elapsedTime);
        runtime.setText(Long.toString(elapsedTime)+" MilliSecond");
        nextMotion(null);
    }

    @FXML
    void nextMotion(ActionEvent event) {
        try {
            if (count> Path.size()){
                System.out.println("enddd");
                return;
            }
            System.out.println("Path size" + Path.size());
            move(Path.get(count).getState());
            System.out.println(Arrays.toString( Path.get(count).getState()));
            count++;
            System.out.println("jere " + Integer.toString(count));

        }catch (Exception e){
            System.out.println("error in next motion");
        }
    }
}
