// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

import java.util.LinkedList;

public class PopulatingNextRightPointersEachNode {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String... args) {
        Node n = new Node(1, new Node(2, new Node(4, new Node(8), new Node(9), null), new Node(5, new Node(10), new Node(11), null), null), new Node(3, new Node(6, new Node(12), new Node(13), null), new Node(7, new Node(14), new Node(15), null), null), null);
        connect(n);

        Node n2 = new Node(1, new Node(2, new Node(4, new Node(8), new Node(9), null), new Node(5, new Node(10), new Node(11), null), null), new Node(3, new Node(6, new Node(12), new Node(13), null), new Node(7, new Node(14), new Node(15), null), null), null);
        connect2(n2);
    }

    private static Node connect2(Node root) {
        if (root == null || root.left == null || root.right == null) return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;

        connect2(root.left);
        connect2(root.right);
        return root;
    }

    public static Node connect(Node root) {
        if (root == null) return root;

        Node leftNode = root;
        while (leftNode.left != null) {
            Node head = leftNode;
            System.out.println("left:" + head.val);
            while (head != null) {
                System.out.println("\thead:" + head.val);
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }

            leftNode = leftNode.left;
        }
        return root;
    }


}
