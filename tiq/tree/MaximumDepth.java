package tiq.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its depth = 3.
 */
public class MaximumDepth {
    public static int run() {
        int[] values = {9, 20, 15, 7};
        BinaryTree tree = new BinaryTree(3);
        for (int value : values) {
            tree.add(value);
        }
        tree.traverseInOrder(tree.getRoot());

        System.out.println("\nmax depth:");
        int ans = maxDepth3(tree.getRoot());
        System.out.println(ans);

        return ans;
    }

    /**
     * find maximum depth of a given binary tree: recursive solution
     * <p>
     * O(n) time, O(n) (stack) space
     * </p>
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the nodes in the tree
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }


    /**
     * find maximum depth of a given binary tree: iterative depth-first solution
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the nodes in the tree
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);
        int maxDepth = 0;
        // go as deep as possible on the left subtrees before visiting right subtrees
        // remember stack is LIFO, pushing left subtrees last means they are always popped first
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            int currDepth = depth.pop();
            maxDepth = Math.max(maxDepth, currDepth);
            if (currNode.right != null) {
                stack.push(currNode.right);
                depth.push(currDepth + 1);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
                depth.push(currDepth + 1);
            }
        }
        return maxDepth;
    }

    /**
     * find maximum depth of a given binary tree: iterative breadth-first solution
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the nodes in the tree
     */
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int queueSize = 1;
        int depth = 0;
        // while there are more layers to check
        while (!queue.isEmpty()) {
            int tempSize = 0;
            // add all children of current layer to the queue (FIFO)
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    tempSize++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    tempSize++;
                }
            }
            queueSize = tempSize;
            depth++;
        }
        return depth;
    }
}
