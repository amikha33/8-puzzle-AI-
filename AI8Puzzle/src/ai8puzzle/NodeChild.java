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
   
   
   
   }
}
