// https://leetcode.com/problems/binary-tree-level-order-traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList x = new LinkedList();

        if (root == null) return x;

        LinkedList<TreeNode> tmp = new <TreeNode>LinkedList();
        LinkedList level;
        int count = 0;

        tmp.add(root);

        while (!tmp.isEmpty()) {
            count = tmp.size();
            level = new LinkedList();
            while (count > 0) {
                count--;
                TreeNode current = tmp.removeFirst();
                level.add(current.val);
                if (current.left != null) tmp.add(current.left);
                if (current.right != null) tmp.add(current.right);
            }
            x.add(level);
        }
        return x;
    }

}
