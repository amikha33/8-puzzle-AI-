package Algorithim_Model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 * @author Aghapy
 */
public class Node {
    /**  (RIGHT = childre[0], LEFT = childre[1], UP = childre[2], DOWN = childre[3]).**/
    private int[] state = new int[9];
    private ArrayList<Node> children;
    private Node parent;


    public Node(int[] state , Node parent) {
        this.state = state;
        this.parent = parent;
    }



    public void generateChildren() {
        children = new ArrayList<>();
        int emptyTile = -1;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                emptyTile = i;
            }
        }
        moveTile(emptyTile);
    }

    private void moveTile(int emptyTile) {
       ArrayList<Node> newChildren = new ArrayList<>();
        switch (emptyTile) {
            case 0:
                newChildren.add(0, moveRight(emptyTile) );
                newChildren.add(3,  moveDown(emptyTile) );
                break;
            case 1:
                newChildren.add(0,  moveRight(emptyTile) );
                newChildren.add(1,  moveLeft(emptyTile) );
                newChildren.add(3,  moveDown(emptyTile) );
            case 2:
                newChildren.add(1,  moveLeft(emptyTile) );
                newChildren.add(3,  moveDown(emptyTile) );
            case 3:
                newChildren.add(0,  moveRight(emptyTile) );
                newChildren.add(2,  moveUp(emptyTile) );
                newChildren.add(3,  moveDown(emptyTile) );
            case 4:
                newChildren.add(0,  moveRight(emptyTile) );
                newChildren.add(1, moveLeft(emptyTile) );
                newChildren.add(2,  moveUp(emptyTile) );
                newChildren.add(3,  moveDown(emptyTile) );
            case 5:
                newChildren.add(1,  moveLeft(emptyTile) );
                newChildren.add(2,  moveUp(emptyTile) );
                newChildren.add(3, moveDown(emptyTile) );
            case 6:
                newChildren.add(0,  moveRight(emptyTile) );
                newChildren.add(2,  moveUp (emptyTile) );
            case 7:
                newChildren.add(0,  moveRight(emptyTile) );
                newChildren.add(1,  moveLeft(emptyTile) );
                newChildren.add(2,  moveUp (emptyTile) );
            case 8:
                newChildren.add(1,  moveLeft(emptyTile) );
                newChildren.add(2,  moveUp(emptyTile) );
        }
        for (Node newChild:newChildren) {
            if (parent != null) {
                if (!newChild.getState().equals(parent.getState())) {
                    children.add(newChild);
                }
            }
        }
    }


    private Node moveUp(int emptyTile) {
        int[] newState = state.clone();
        swapTwoNosInArray(newState, emptyTile, emptyTile - 3);
        return new Node(newState,this);
    }

    private Node moveDown(int emptyTile) {
        int[] newState = state.clone();
        swapTwoNosInArray(newState, emptyTile, emptyTile + 3);
        return new Node(newState,this);
    }

    private Node moveRight(int emptyTile) {
        int[] newState = state.clone();
        swapTwoNosInArray(newState, emptyTile, emptyTile + 1);
        return new Node(newState,this);
    }

    private Node moveLeft(int emptyTile) {
        int[] newState = state.clone();
        swapTwoNosInArray(newState, emptyTile, emptyTile - 1);
        return new Node(newState, this);
    }

    private void swapTwoNosInArray(int[] array, int firstIndex, int secondIndex) {
        int buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
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
    /**int  state [] ;
     ArrayList<Integer> neighbors = new ArrayList<Integer>();





     int getNeighbors(int[] children) {
     // Find the block element (stored as 0)

     int blockIndex = 0;
     for (int i = 0; i < children.length; i++) {
     if (this.state[i] == 0) {
     blockIndex = i;
     break;
     }




     }
     return blockIndex;
     }
     void move(int blockIndex , int[] children){
     for  (int i = 0; i < children.length; i++) {


     // Try moving the Block left
     if (blockIndex % 3 != 0) {
     int[] other = new int[children.length];
     System.arraycopy(this.state, 0, other, 0, children.length);
     other[blockIndex] = this.state[blockIndex - 1];
     other[blockIndex - 1] = 0;
     neighbors.add(other[i]);

     }

     // Try moving the blank right
     if (blockIndex % 3 != 2) {
     int[] other = new int[children.length];
     System.arraycopy(this.state, 0, other, 0,children.length);
     other[blockIndex] = this.state[blockIndex + 1];
     other[blockIndex + 1] = 0;
     neighbors.add(other[i]);

     }

     // Try moving the blank up
     if (blockIndex >= 3) {
     int[] other = new int[children.length];
     System.arraycopy(this.state, 0, other, 0, children.length);
     other[blockIndex] = this.state[blockIndex - 3];
     other[blockIndex - 3] = 0;
     neighbors.add(other[i]);

     }

     // Try moving the blank down
     if (blockIndex < children.length -3) {
     int[] other = new int[children.length];
     System.arraycopy(this.state, 0, other, 0,children.length);
     other[blockIndex] = this.state[blockIndex + 3];
     other[blockIndex + 3] = 0;
     neighbors.add(other[i]);

     }
     }

     }**/
}
