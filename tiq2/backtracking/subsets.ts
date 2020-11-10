
/**
Given a set of distinct integers, nums, return all possible subsets (the
power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 */
export function runSubsets() {
    const test = [1,2,3];
    const ans = subsets(test);
    console.log(ans);
};

/**
 * O(n * 2^n) time and space
 */
function subsets(nums: number[]): number[][] {
    const n = nums.length;
    let output: number[][] = [[]];

    nums.forEach(num => {
        output.forEach( curr => {
            output = [...output, [...curr, num]];
        });
    });
    return output;
};

