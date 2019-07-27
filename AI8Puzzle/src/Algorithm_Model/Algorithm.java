package Algorithm_Model;

import java.util.ArrayList;

public interface Algorithm {

    public ArrayList<Node> search(int [] board, Node parent);
    public int getExploredNodes();
    public int getMaxDepth();
    public int getCostPath();
}
