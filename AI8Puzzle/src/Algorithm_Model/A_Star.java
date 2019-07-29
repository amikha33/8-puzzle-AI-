package Algorithm_Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A_Star implements Algorithm{

    Heuristic heuristicType;




    @Override
    public ArrayList<Node> search(int[] board, Node parent) {
        return null;
    }

    @Override
    public int getExploredNoOfNodes(int [] goal) {
        boolean solutionExists = false;

        return 0;




    }


    @Override
    public int getMaxDepth() {
        return 0;
    }

    @Override
    public int getCostPath() {
        return 0;
    }


    public Heuristic getHeuristicType() {
        return heuristicType;
    }

    public void setHeuristicType(Heuristic heuristicType) {
        this.heuristicType = heuristicType;
    }
}
