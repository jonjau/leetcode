package tiq.array;

/**
 * RemoveDuplicatesFromSortedArray
 */
public class RemoveDuplicatesFromSortedArray {

    public int run() {
        int[] l1 = { 1, 1, 2, 2, 3, 3, 3, 4, 7, 19 };
        return removeDuplicatesFromSortedArray(l1);
    }

    public int removeDuplicatesFromSortedArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int anchor_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[anchor_index]) {
                anchor_index++;
                nums[anchor_index] = nums[i];
            }
        }
        return anchor_index + 1;
    }
}