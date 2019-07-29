package Algorithm_Model;

import java.util.ArrayList;
import java.util.Stack;

public interface Algorithm {

    public ArrayList<Node> search(int [] board, Node parent);
    public int getExploredNoOfNodes(Stack<Node> solutionPath);
    public int getMaxDepth();
    public int getCostPath();
}
