package tiq.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    /**
     * https://stackoverflow.com/questions/5071040/java-convert-integer-to-string
     */
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix)
                    .append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ")
                .append(this.val).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix)
                    .append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    public String asString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
