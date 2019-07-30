package Algorithm_Model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import utility.Utility;

import java.util.ArrayList;
import java.util.Arrays;



public class Node {

    /**
     * (RIGHT = childre[0], LEFT = childre[1], UP = childre[2], DOWN =
     * childre[3]).
     *
     */
    protected int[] state = new int[9];
    private ArrayList<Node> children;
    private Node parent;
    private int depth;
    public Node(int[] state, Node parent) {
        if (parent == null){
            depth = 0;
        }else {
            depth = parent.depth+1;
        }
        this.state = state;
        this.parent = parent;
    }

    Node(EightPuzzleState eightPuzzleState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public void generateChildren() {
        children = new ArrayList<>(Arrays.asList(new Node[4]));
        int emptyTile = -1;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                emptyTile = i;
                break;
            }
        }
        moveTile(emptyTile);
    }

    private void moveTile(int emptyTile) {
        ArrayList<Node> newChildren = new ArrayList<>(Arrays.asList(new Node[4]));
        switch (emptyTile) {
            case 0:
                newChildren.set(0, moveRight(emptyTile));
                newChildren.set(3, moveDown(emptyTile));
                break;
            case 1:
                newChildren.set(0, moveRight(emptyTile));
                newChildren.set(1, moveLeft(emptyTile));
                newChildren.set(3, moveDown(emptyTile));
                break;

            case 2:
                newChildren.set(1, moveLeft(emptyTile));
                newChildren.set(3, moveDown(emptyTile));
                break;

            case 3:
                newChildren.set(0, moveRight(emptyTile));
                newChildren.set(2, moveUp(emptyTile));
                newChildren.set(3, moveDown(emptyTile));
                break;

            case 4:
                newChildren.set(0, moveRight(emptyTile));
                newChildren.set(1, moveLeft(emptyTile));
                newChildren.set(2, moveUp(emptyTile));
                newChildren.set(3, moveDown(emptyTile));
                break;

            case 5:
                newChildren.set(1, moveLeft(emptyTile));
                newChildren.set(2, moveUp(emptyTile));
                newChildren.set(3, moveDown(emptyTile));
                break;

            case 6:
                newChildren.set(0, moveRight(emptyTile));
                newChildren.set(2, moveUp(emptyTile));
                break;

            case 7:
                newChildren.set(0, moveRight(emptyTile));
                newChildren.set(1, moveLeft(emptyTile));
                newChildren.set(2, moveUp(emptyTile));
                break;

            case 8:
                newChildren.set(1, moveLeft(emptyTile));
                newChildren.set(2, moveUp(emptyTile));
                break;

        }
        //System.out.println("Size of new children is "+ newChildren.size());
        if (parent != null) {
            for (Node newChild : newChildren) {
                if (newChild != null) {
                    if (!newChild.getState().equals(parent.getState())) {
                        children.set(newChildren.indexOf(newChild), newChild);
                    }
                }
            }
        }else {
            for (Node newChild : newChildren) {
                if (newChild != null) {
                        children.set(newChildren.indexOf(newChild), newChild);
                }
            }
        }
        //System.out.println("Size of Children is " + children.size());
    }

    protected Node moveUp(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile - 3);
        return new Node(newState, this);
    }

    protected Node moveDown(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile + 3);
        return new Node(newState, this);
    }

    protected Node moveRight(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile + 1);
        return new Node(newState, this);
    }

    protected Node moveLeft(int emptyTile) {
        int[] newState = state.clone();
        Utility.swapTwoNosInArray(newState, emptyTile, emptyTile - 1);
        return new Node(newState, this);
    }



    public int[] getState() {
        return state;
    }


    public void setState(int[] state) {
        this.state = state;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDepth() {
        return depth;
    }

    boolean isGoal() {
      EightPuzzleState n = new EightPuzzleState(state);

        return Arrays.equals(n.curBoard, n.GOAL);}


}
