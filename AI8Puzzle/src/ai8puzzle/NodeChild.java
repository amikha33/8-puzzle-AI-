/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai8puzzle;

import java.util.ArrayList;

/**
 *
 * @author Aghapy
 */
public class NodeChild {
    int  state [] ;
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
   
   // Try moving the Block left
        if (blockIndex % 3 != 0) {
            int[] other = new int[children.length];
            System.arraycopy(this.state, 0, other, 0, children.length);
            other[blockIndex] = this.state[blockIndex - 1];
            other[blockIndex - 1] = 0;
        }

        // Try moving the blank right
        if (blockIndex % 3 != 2) {
            int[] other = new int[children.length];
            System.arraycopy(this.state, 0, other, 0,children.length);
            other[blockIndex] = this.state[blockIndex + 1];
            other[blockIndex + 1] = 0;
        }

        // Try moving the blank up
        if (blockIndex >= 3) {
            int[] other = new int[children.length];
            System.arraycopy(this.state, 0, other, 0, children.length);
            other[blockIndex] = this.state[blockIndex - 3];
            other[blockIndex - 3] = 0;
        }

        // Try moving the blank down
        if (blockIndex < children.length -3) {
            int[] other = new int[children.length];
            System.arraycopy(this.state, 0, other, 0,children.length);
            other[blockIndex] = this.state[blockIndex + 3];
            other[blockIndex + 3] = 0;
        }
   
   }
}
