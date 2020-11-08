package tiq2.treesandgraphs

import java.util.*

fun runKthSmallestElementInBST() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(20)
    root.right!!.right = TreeNode(25)
    root.right!!.left = TreeNode(15)

    val res = kthSmallest1(root, 1)
    println(res)
}

// O(n) time, O(n) space
fun kthSmallest(root: TreeNode?, k: Int): Int =
        inOrderTraversal(root)[k-1]

// O(h+k) time, O(h) space, where h is the height of the BST
fun kthSmallest1(root: TreeNode?, k: Int): Int {
    val stack = LinkedList<TreeNode>()
    var curr = root
    var count = k

    while (true) {
        while (curr != null) {
            stack.add(curr)
            curr = curr.left
        }
        curr = stack.removeLast()
        count--
        if (count == 0) {
           return curr.`val`
        }
        curr = curr.right
    }
}

// doesn't work
//fun kthSmallest2(root: TreeNode?, k: Int): Int? {
//    when {
//        k == 0 -> root?.`val`
//        else -> {
//            if (root != null) {
//                val left = kthSmallest2(root.left, k-1)
//                val right  = kthSmallest2(root.right, k-1)
//                return left ?: right
//            } else {
//                return null
//            }
//        }
//    }
//}
//
