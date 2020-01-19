package tiq.util;

import java.util.Arrays;
import java.util.Random;

/**
 * RandomIntArray
 */
public class ArrayUtils {

    public static int[] nonnegatives(int n, int max) {
        return nonnegatives(n, max, 123);
    }

    public static int[] nonnegatives(int n, int max, long seed) {
        Random random = new Random(seed);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }

    public static void printIntArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void print2DIntArray(int[][] A) {
        System.out.println("[");
        for (int[] array : A) {
            System.out.println("    ");
            printIntArray(array);
        }
        System.out.println("]");
    }
}