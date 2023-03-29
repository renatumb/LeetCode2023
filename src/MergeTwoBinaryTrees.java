// https://leetcode.com/problems/merge-two-binary-trees

public class MergeTwoBinaryTrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String... args) {

        TreeNode r1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null));
        TreeNode r2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode result = mergeTrees(r1, r2);

        TreeNode r3 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null));
        TreeNode r4 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode result2 = mergeTrees2(r3, r4);

    }

    private static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val = root1.val + root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);

        return root1;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;
        merge(root1, root2);

        return root1;
    }

    private static void merge(TreeNode n1, TreeNode n2) {
        if (n2 == null) return;

        n1.val += n2.val;

        if (n1.left == null && n2.left != null) {
            if (n1.left == null) n1.left = new TreeNode(0);
        }
        merge(n1.left, n2.left);

        if (n1.right == null && n2.right != null) {
            if (n1.right == null) n1.right = new TreeNode(0);
        }
        merge(n1.right, n2.right);
    }
}




