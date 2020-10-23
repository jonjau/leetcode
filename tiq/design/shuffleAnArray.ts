/**
 * Shuffle a set of numbers without duplicates.
 * 
 * Example:
 * 
 * // Init an array with set 1, 2, and 3.
 * 
 * int[] nums = {1,2,3}; Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result.
 *    Any permutation of [1,2,3] must equally likely to be returned.
 * 
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * 
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * 
 * solution.shuffle();
 *
 * Hint #1 The solution expects that we always use the original array to
 * shuffle() else some of the test cases fail. (Credits; @snehasingh31)
 */
class Solution {
    array: number[];
    original: number[];

    constructor(nums: number[]) {
        this.original = nums;
        this.array = [...nums];
    }

    reset(): number[] {
        this.array = this.original;
        this.original = [...this.original];
        return this.array;
    }

    /**
     * O(n^2) time, O(n) space
     * brute force, see Fisher-Yates
     */
    shuffle2(): number[] {
        let aux = [...this.array];
        for (let i = 0; i < this.array.length; i++) {
            // get a random index, then put the element at that index into
            // the array to return
            const idx = Math.floor(Math.random() * aux.length);
            this.array[i] = aux[idx];

            // remove the the idx'th element
            aux = aux.filter((_,j) => j !== idx);
        }
        return this.array;
    }

    /**
     * O(n) time, O(n) space
     * Fisher-Yates: instead of pulling from an aux array we swap elements
     * within the array itself.
     */
    shuffle(): number[] {
        for (let i = 0; i < this.array.length; i++) {
            const idx = i + Math.floor(Math.random() * (this.array.length - i));
            [this.array[i], this.array[idx]] = [this.array[idx], this.array[i]];
        }
        return this.array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */

export function runShuffleAnArray() {
    const s = new Solution([1,2,3]);
    console.log(s.array);
    const res1 = s.shuffle();
    console.log(res1);
    const res2 = s.reset();
    console.log(res2);
}