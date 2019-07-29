package Algorithm_Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class A_Star implements Algorithm {

    private GreedyNode initialState;
    private Heuristic heuristicType;
    private PriorityQueue<GreedyNode> frontier;
    private ArrayList<GreedyNode> frontierList;
    private ArrayList<GreedyNode> explored;
    private ArrayList<Node> path;


    public A_Star(Heuristic heuristicType) {
        this.heuristicType = heuristicType;
    }

    @Override
    public ArrayList<Node> search(int[] board, Node parent) {
        initialState = (GreedyNode) new Node(board, null);
        frontier = new PriorityQueue<>();
        frontierList = new ArrayList<>();
        frontier.add(initialState);
        frontierList.add(initialState);
        explored = new ArrayList<>();
        while (!frontier.isEmpty()) {
            GreedyNode state = frontier.poll();
            frontierList.remove(state);
            explored.add(state);

            if (state.isGoal()) {
                return pathToGoal(state);
            }
            state.generateChildren();
            for (Node node : state.getChildren()) {
                node = (GreedyNode) new GreedyNode(node.state, state);
                if (!frontier.contains(node) && explored.contains(node)) {
                    calculateWeight((GreedyNode) node);
                    frontier.add((GreedyNode) node);
                } else if (frontier.contains(node)) {

                }
            }


        }
        return null;
    }

    private boolean containing(GreedyNode node) {
        for (GreedyNode test : frontierList) {
            if (java.util.Arrays.equals(test.state, node.state)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Node> pathToGoal(GreedyNode state) {
        ArrayList<Node> pathToGoal = new ArrayList<>();
        path = pathToGoal;
        return pathToGoal;
    }

    private void calculateWeight(GreedyNode greedyNode) {
        greedyNode.setWeight(heuristicType.getHeuristic(greedyNode.getState()));
    }

    public ArrayList<GreedyNode> getExplored() {
        return explored;
    }

    public void setExplored(ArrayList<GreedyNode> explored) {
        this.explored = explored;
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

    @Override
    public int getExploredNoOfNodes() {
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
