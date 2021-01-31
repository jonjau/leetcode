/**
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 6
 *     -10 <= nums[i] <= 10
 *     All the integers of nums are unique.
 */
export const runPermutations = () => {
  const cases = [[1, 2, 3], [0, 1], [1], []];
  const results = cases.map((c) => permute(c));
  console.log(results);
};

/**
 * no reference! No-loop approach
 * 
 * Most likely:
 * 
 * O(n^2) time, O(n^2) space
 * 
 * @param nums 
 */
function permute(nums: number[]): number[][] {
  if (nums.length <= 1) {
    return [nums];
  }

  let result: number[][] = [];
  nums.forEach((num) => {
    const rest = nums.filter((x) => x !== num);
    const permuted = permute(rest);
    const permutations = permuted.map((l) => [num, ...l]);
    result = result.concat(permutations);
  });
  return result;
}
