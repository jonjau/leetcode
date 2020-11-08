package tiq2.treesandgraphs

fun runBinaryTreeFromPreorderAndInorder() {
//    val root = TreeNode(3)
//    root.left = TreeNode(9)
//    root.right = TreeNode(20)
//    root.right!!.right = TreeNode(7)
//    root.right!!.left = TreeNode(15)
    val pre = intArrayOf(3,9,20,15,7)
    val ino = intArrayOf(9,3,15,20,7)

    // expect [9, 3, 15, 20, 7]
    val res = binaryTreeFromPreorderAndInorder(pre, ino)
    println(inOrderTraversal(res))
}

val IntArray.tail: IntArray
    get() = drop(1).toIntArray()

val IntArray.head: Int
    get() = first()

// O(??) time, O(n) space
fun binaryTreeFromPreorderAndInorder(preorder: IntArray, inorder: IntArray): TreeNode? =
    when (inorder.size) {
        0 -> null
        else -> {
            val index =  inorder.indexOf(preorder.head)
            val leftIn = inorder.sliceArray(0..index-1)
             val rightIn = inorder.sliceArray(index+1..preorder.size-1)
            val leftPre = preorder.sliceArray(1..leftIn.size)
            val rightPre = preorder.sliceArray(leftIn.size+1..preorder.size-1)

            val left = binaryTreeFromPreorderAndInorder(leftPre, leftIn)
            val right = binaryTreeFromPreorderAndInorder(rightPre, rightIn)
            val root = TreeNode(preorder.head)
            root.left = left
            root.right = right
            root
        }
    }

infix fun IntArray.splitAt(index: Int): Pair<IntArray, IntArray> =
        Pair(
                this.sliceArray(0 until index),
                this.sliceArray(index+1 until this.size)
        )
