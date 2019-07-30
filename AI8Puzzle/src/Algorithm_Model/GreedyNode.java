package Algorithm_Model;


import utility.Utility;

/**
 * @author Harraz21
 * <p>
 * weight = cost + heuristic
 **/


public class GreedyNode extends Node implements Comparable<GreedyNode> {

    private int cost;
    private double weight;


    public GreedyNode(int[] state, GreedyNode parent) {
        super(state, parent);
        if (parent == null) {
            cost = 0;
        } else {
            cost = parent.getCost() + 1;
        }
    }

    @Override
    public int compareTo(GreedyNode greedyNode) {
        return (int) (this.weight - greedyNode.weight);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GreedyNode(int[] state, Node parent) {
        super(state, parent);
    }

    @Override
    protected GreedyNode moveUp(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile - 3);
        return new GreedyNode(newState, this);
    }

    @Override
    protected GreedyNode moveDown(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile + 3);
        return new GreedyNode(newState, this);
    }

    @Override
    protected GreedyNode moveRight(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile + 1);
        return new GreedyNode(newState, this);
    }

    @Override
    protected GreedyNode moveLeft(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile - 1);
        return new GreedyNode(newState, this);
    }
}
