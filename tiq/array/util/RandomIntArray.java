package tiq.array.util;

import java.util.Random;
import java.util.Arrays;

/**
 * RandomIntArray
 */
public class RandomIntArray {

    public static int[] nonnegatives(int n, int max) {
        return nonnegatives(n, max, 123);
    }
    public static int[] nonnegatives(int n, int max, long seed) {
        Random random = new Random(seed);
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }
    
    public static void printIntArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}