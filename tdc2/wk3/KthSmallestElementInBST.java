package tdc2.wk3;

import tiq.tree.BinarySearchTree;
import tiq.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth
 * smallest frequently? How would you optimize the kthSmallest routine?
 * Hide Hint #1
 * Try to utilize the property of a BST.
 * Hide Hint #2
 * Try in-order traversal. (Credits to @chan13)
 * Hide Hint #3
 * What if you could modify the BST node's structure?
 * Hide Hint #4
 * The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementInBST {
    public static int run() {
        BinarySearchTree tree = new BinarySearchTree(3);
        tree.add(4);
        tree.add(1);
        tree.add(2);
        int ans = kthSmallestElementInBST1(tree.getRoot(), 1);
        System.out.println(ans);
        return ans;
    }

    /**
     * suboptimal solution: recursive in order traversal, then get the k-1 th element.
     * @param root the root node of the BST
     * @param k an integer
     * @return the kth smallest element in the BST
     */
    public static int kthSmallestElementInBST1(TreeNode root, int k) {
        List<Integer> nums = inOrder(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    /**
     * @param node         the node to start the in order traversal from
     * @param nodesVisited a list of the nodes visited so far
     * @return a list of nodes, in order traversal
     */
    public static List<Integer> inOrder(TreeNode node, List<Integer> nodesVisited) {
        if (node == null) {
            return nodesVisited;
        }
        inOrder(node.left, nodesVisited);
        nodesVisited.add(node.val);
        inOrder(node.right, nodesVisited);
        return nodesVisited;
    }
}
