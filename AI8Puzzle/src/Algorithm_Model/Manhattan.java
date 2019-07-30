package Algorithm_Model;

import utility.Utility;

/**
 * @author Harraz21
 */

public class Manhattan implements Heuristic {
    @Override
    public double getHeuristic(int[] state) {
        int x;
        int y;
        double sum = 0;
        for (int i = 0; i < 9; i++) {
            sum = sum + Utility.manhattanDistance(Utility.getX(i), Utility.getX(state[i]), Utility.getY(state[i]), Utility.getY(i));
        }
        return sum;
    }
}
