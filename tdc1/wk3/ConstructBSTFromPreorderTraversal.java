package tdc1.wk3;

import tiq.tree.TreeNode;

import java.util.Stack;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of
 * node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also
 * recall that a preorder traversal displays the value of the node first, then traverses node.left,
 * then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12] Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100 The values of preorder are distinct.
 */
public class ConstructBSTFromPreorderTraversal {
    public static TreeNode run() {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = constructBSTFromPreorderTraversal1(preorder);
        System.out.println(root.toString());
        return root;
    }

    /**
     * Iterative stack approach
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param preorder an integer array resulting from a preorder traversal of a tree
     *                 with length between 1 and 100 inclusive, and distinct elements
     * @return the BST that the preorder array represents
     */
    public static TreeNode constructBSTFromPreorderTraversal1(int[] preorder) {
        // we are given 1 <= preorder.length <= 100
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode lastNode = stack.peek();
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < lastNode.val) {
                // node is the left child of the lastNode
                lastNode.left = node;
            } else {
                // node is the right child of some ancestor, just check BST order
                while (!stack.empty() && preorder[i] > stack.peek().val) {
                    lastNode = stack.pop();
                }
                lastNode.right = node;
                // we are given that the values of preorder are distinct,
                // no real need to consider '='
            }
            stack.push(node);
        }
        return root;
    }
}
