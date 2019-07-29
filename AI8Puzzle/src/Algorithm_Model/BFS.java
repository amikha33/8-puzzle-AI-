package Algorithm_Model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Aghapy
 */
public class BFS implements Algorithm{

    @Override
    public ArrayList<Node> search(int [] board, Node parent ) {
        Queue<Node> queue = new LinkedList<Node>();
        Node root = new Node(board, null);
        queue.add(root);

        //performSearch(queue);

        return performSearch(queue);
    }

    @Override
    public int getExploredNoOfNodes(Stack<Node> solutionPath) {
        //number of nodes
        Stack<Node> s = solutionPath;
        int pathLength =0;
        //getPath solution paths and Stack S :"D

        while(s.isEmpty() == false){
            System.out.println(s.pop());
            pathLength ++;
        }
        return pathLength;
    }



    @Override
    public int getMaxDepth(Stack<Node> solutionPath , int [] goal) {
        int maxDepth=0;
        for (int i = 0; i <solutionPath.size(); i++) {


                Node popedChild = solutionPath.pop();
                if (popedChild.equals(goal)) {
                    break;
                }
                maxDepth = maxDepth + 1;

        }
        return maxDepth;
    }

    @Override
    public int getCostPath() {
        //no  Cost int BFS
        return 0;

    }

    /*
         * Helper method to check to see if a SearchNode has already been evaluated.
         * Returns true if it has, false if it hasn't.
         */
        private static boolean checkRepeats(Node n) {
            boolean retValue = false;
            Node checkNode = n;

            // While n's parent isn't null, check to see if it's equal to the node
            // we're looking for.
            while (n.getParent() != null && !retValue) {
                if (n.getParent().getState().equals(checkNode.getState())) {
                    retValue = true;
                }
                n = n.getParent();
            }

            return retValue;
        }

        /**
         * Performs a BFSearch using q as the search space
         *
         * @param q - A SearchNode queue to be populated and searched
         */
        public ArrayList<Node> performSearch(Queue<Node> q) {
            int searchCount = 1; // counter for number of iterations
            ArrayList<Node> frontierList = new ArrayList();

            while (!q.isEmpty()) // while the queue is not empty
            {
                //System.out.println("Ssize of queue"+q.size());
                Node tempNode = q.poll();
                frontierList.add(tempNode);
                if (!tempNode.isGoal()) // if tempNode is not the goal
                // state
                {
//                    System.out.println(tempNode.getState()[0]+" "+tempNode.getState()[1]+" "+tempNode.getState()[2]+"\n"+
//                            tempNode.getState()[3]+" "+tempNode.getState()[4]+" "+tempNode.getState()[5]+"\n"+
//                            tempNode.getState()[6]+" "+tempNode.getState()[7]+" "+tempNode.getState()[8]+"\n"
//                    );
                    tempNode.generateChildren();
                    ArrayList<Node> Children = tempNode.getChildren();
                    //System.out.println(Children.size());
                    for (int i = 0; i < Children.size(); i++) {
                        if (Children.get(i) == null)
                            continue;
                        boolean duplicate = false;
                        for (Node j:
                             frontierList) {

                            if (Arrays.toString(j.getState()).equalsIgnoreCase(Arrays.toString(Children.get(i).getState())))
                                duplicate = true;
//                            if (Arrays.equals(Children.get(i).getState(),j.getState()))
//                                duplicate = true;
                        }
                        if (duplicate == true)
                            continue;
                        int [] qq = Children.get(i).getState();

                        // second parameter here adds the cost of the new node to
                        // the current cost total in the SearchNode
                     //   System.out.println("Not Null at "+i);
                        Node newNode = Children.get(i);
                        q.add(newNode);
//                        System.out.println(newNode.getState()[0]+" "+newNode.getState()[1]+" "+newNode.getState()[2]+"\n"+
//                                newNode.getState()[3]+" "+newNode.getState()[4]+" "+newNode.getState()[5]+"\n"+
//                                newNode.getState()[6]+" "+newNode.getState()[7]+" "+newNode.getState()[8]+"\n"
//                        );
                        if (!checkRepeats(newNode)) {
                            //System.out.println("Added Child to Queue");
                           // q.add(newNode);
                        }
                    }
                    searchCount++;
                } else
                // The goal state has been found. Print the path it took to get to
                // it.
                {
                    // Use a stack to track the path from the starting state to the
                    // goal state
                    Stack<Node> solutionPath = new Stack<Node>();
                    solutionPath.push(tempNode);
                    tempNode = tempNode.getParent();

                    while (tempNode.getParent() != null) {
                        solutionPath.push(tempNode);
                        tempNode = tempNode.getParent();
                    }
                    solutionPath.push(tempNode);
                    // The size of the stack before looping through and emptying it.
                    int loopSize = solutionPath.size();
                    Collections.reverse(solutionPath);
                     int[] arr = new int[]
                            {0, 1, 2, 3, 4, 5, 6, 7, 8};

                   // getMaxDepth(solutionPath,arr);
                    System.out.println("sent list");
                    return new ArrayList(solutionPath);

                }
                /*
                    for (int i = 0; i < loopSize; i++) {
                        tempNode = solutionPath.pop();
                        tempNode.getState();
                        System.out.println();
                        System.out.println();
                    }
                    break;
                    //System.exit(0);
                }*/
            }
            System.out.println("Shouldn't reach this statment");
            return null;
            // This should never happen with our current puzzles.
            //System.out.println("Error! No solution found!");
        }


}
