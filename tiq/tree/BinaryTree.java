package tiq.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #j from Baeldung
 */
public class BinaryTree {
    TreeNode root;

    public BinaryTree(int rootValue) {
        this.root = new TreeNode(rootValue);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * Recursive insertion method
     *
     * @param current current node to consider
     * @param value   value to be inserted
     * @return the inserted TreeNode with the given value
     */
    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        }
        // value is already in tree
        return current;
    }

    /**
     * Insert value in sorted order
     *
     * @param value the value to be added
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * Recursive finding method
     *
     * @param current current node to consider
     * @param value   value to be checked for
     * @return whether the value is under the current node
     */
    private boolean containsValueRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value < current.val) {
            return containsValueRecursive(current.left, value);
        } else if (value > current.val) {
            return containsValueRecursive(current.right, value);
        }
        // current node has sought value
        return true;
    }

    /**
     * Find value in tree
     *
     * @param value the value to be found
     */
    public boolean containsValue(int value) {
        return containsValueRecursive(root, value);
    }

    //TODO: Delete a node in the tree

    /**
     * Traverses depth-first (in-order) and prints the values, recursively.
     * <p>
     * In-order traversal consists of first visiting the left sub-tree, then the root node, and
     * finally the right sub-tree
     *
     * @param node the node from which to traverse
     */
    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(" " + node.val);
            traverseInOrder(node.right);
        }
    }

    /**
     * Traverses depth-first (pre-order) and prints the values, recursively
     * <p>
     * Pre-order traversal visits first the root node, then the left subtree, and finally the right
     * subtree
     *
     * @param node the node from which to traverse
     */
    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.println(" " + node.val);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    /**
     * Traverses depth-first (post-order) and prints the values, recursively
     * <p>
     * Post-order traversal visits the left subtree, the right subtree,
     * and the root node at the end
     *
     * @param node the node from which to traverse
     */
    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(" " + node.val);
        }
    }

    /**
     * Traverses breadth-first (level-order) and prints the values, iteratively
     * <p>
     * visits all the nodes of a level before going to the next level
     */
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.remove();

            System.out.print(" " + node.val);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
