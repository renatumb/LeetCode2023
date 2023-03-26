// https://leetcode.com/problems/middle-of-the-linked-list

public class MiddleOfLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return Integer.toString(this.val);
        }
    }

    public static void main(String args[]) {

        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node3 = new ListNode(1);

        System.out.println(middleNode(node1));
        System.out.println(middleNode2(node1));

        System.out.println(middleNode(node2));
        System.out.println(middleNode2(node2));

        System.out.println(middleNode(node3));
        System.out.println(middleNode2(node3));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        if (head == null || head.next == null) return head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode cur = head;
        int total = 0, mid = 0;

        if (head == null || head.next == null) return head;
        while (cur != null) {
            cur = cur.next;
            ++total;
        }

        mid = total / 2;

        while (mid > 0) {
            head = head.next;
            mid--;
        }
        return head;
    }
}
