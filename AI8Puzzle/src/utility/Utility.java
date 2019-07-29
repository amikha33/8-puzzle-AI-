package utility;

import java.math.*;

public abstract class Utility {
    public static void swapTwoNosInArray(int[] array, int firstIndex, int secondIndex) {
        int buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
    }

    public static double euclideanDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static int manhattanDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    public static int getY(int i) {
        int y;
        if (i < 3) {
            y = 2;
        } else if (i < 6) {
            y = 1;
        } else {
            y = 0;
        }
        return y;
    }


    public static int getX(int i) {
        return i % 3;
    }
}
