// https://leetcode.com/problems/n-ary-tree-preorder-traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreePreorderTraversal {
    List<Integer> result = new ArrayList();

    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        preOrderHelper(root);
        return result;
    }

    public void preOrderHelper(Node node) {
        if (node.children == null) return;
        result.add(node.val);
        for (Node child : node.children) {
            preOrderHelper(child);
        }
    }

    public List<Integer> preorder2_Interactively(Node root) {
        Stack<Node> stack = new Stack<Node>();
        if (root == null) return result;
        stack.add(root);
        while (!stack.empty()) {
            Node n = stack.pop();
            result.add(n.val);

            for (int i = n.children.size() - 1; i >= 0; i--) {
                stack.add(n.children.get(i));
            }
        }
        return result;
    }
}
