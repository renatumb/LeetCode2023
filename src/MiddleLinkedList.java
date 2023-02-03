// https://leetcode.com/problems/middle-of-the-linked-list
public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
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

    public ListNode middleNode2(ListNode head) {
        ListNode fast = head, slow = head;

        if (head == null || head.next == null) return head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
