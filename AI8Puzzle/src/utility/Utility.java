package utility;

public abstract class Utility {
    public static void swapTwoNosInArray(int[] array, int firstIndex, int secondIndex) {
        int buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
    }

}
