// https://leetcode.com/problems/remove-nth-node-from-end-of-list

public class RemoveNthNodeFromEndOfList {

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

        @Override
        public String toString() {
            StringBuilder all = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                all.append(" " + Integer.toString(current.val));
                current = current.next;
            }
            return all.toString();
        }
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(l1, 2));
        ListNode l1a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd2(l1a, 2));

        ListNode l2 = new ListNode(1);
        System.out.println(removeNthFromEnd(l2, 1));
        ListNode l2a = new ListNode(1);
        System.out.println(removeNthFromEnd2(l2a, 1));

        ListNode l3 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(l3, 1));
        ListNode l3a = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd2(l3a, 1));

        ListNode l4 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(l4, 2));
        ListNode l4a = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd2(l4a, 2));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev, current = head;
        int total = 0, count = 0;

        if (current.next == null && n > 0) return null;

        while (current != null) {
            ++total;
            current = current.next;
        }

        current = head;
        ++count;

        if (n == total) return head.next;

        for (; ; ) {
            prev = current;
            current = current.next;
            ++count;
            if (count + n > total) {
                prev.next = current.next;
                break;
            }
        }
        return head;
    }

    private static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode current = head, ahead = head;
        for (int i = 1; i <= n; i++) {
            ahead = ahead.next;
        }
        if (ahead == null) return head.next;
        while (ahead.next != null) {
            ahead = ahead.next;
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
