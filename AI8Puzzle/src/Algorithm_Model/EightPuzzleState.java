/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm_Model;

/**
 *
 * @author Aghapy
 */
public class EightPuzzleState {
    private int manDist = 0;
 final int[] GOAL = new int[]
            {0, 1, 2, 3, 4, 5, 6, 7, 8};

      int[] curBoard;
            // linearly search the array independent of the nested for's below

         private int outOfPlace = 0;

       public EightPuzzleState(int[] board) {
           //System.out.println("here is");
           //System.out.println(board);
           curBoard = board;
           setOutOfPlace();
           setManDist();
        }
     
     
     
        private void setOutOfPlace() {
        for (int i = 0; i < curBoard.length; i++) {
            if (curBoard[i] != GOAL[i]) {
                outOfPlace++;
            }
        }
    }
     
    private void setManDist() {
            int index = -1;
  for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                index++;

                // sub 1 from the val to get the index of where that value
                // should be
                int val = (curBoard[index] - 1);

                /*
                 * If we're not looking at the hole. The hole will be at
                 * location -1 since we subtracted 1 before to turn val into the
                 * index
                 */
                if (val != -1) {
                    // Horizontal offset, mod the tile value by the horizontal
                    // dimension
                    int horiz = val % 3;
                    // Vertical offset, divide the tile value by the vertical
                    // dimension
                    int vert = val / 3;

                    manDist += Math.abs(vert - (y)) + Math.abs(horiz - (x));
                }
                // If we are looking at the hole, skip it
            }
        }
    }
     private int[] copyBoard(int[] state) {
        int[] ret = new int[9];
        for (int i = 0; i < 9; i++) {
            ret[i] = state[i];
        }
        return ret;
    }
    
     
    
    }
    
    
    
    
