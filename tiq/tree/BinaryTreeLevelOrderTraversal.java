package tiq.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> run() {
        int[] values = {9, 20, 15, 7};
        BinarySearchTree tree = new BinarySearchTree(3);
        for (int value : values) {
            tree.add(value);
        }
        tree.traverseInOrder(tree.getRoot());

        System.out.println("\nLevel Order Traversal:");
        List<List<Integer>> ans = levelOrder1(tree.getRoot());
        System.out.println(ans);

        return ans;
    }

    /**
     * return a representation of the given binary tree as a list of lists, where each inner
     * list is a level in the tree
     * <p>
     *     O(n) time, O(n) space
     * </p>
     * @param root the root node of the binary tree
     * @return list of lists representing levels in the binary tree
     */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int numNodesInCurrLevel = queue.size();
            for (int i = 0; i < numNodesInCurrLevel; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            resultList.add(currLevel);
        }
        return resultList;
    }
}
