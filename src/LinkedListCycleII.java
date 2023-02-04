// https://leetcode.com/problems/linked-list-cycle-ii

import java.util.HashSet;
import java.util.TreeSet;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        HashSet visited = new HashSet<ListNode>();
        ListNode c = head;

        while (c != null) {
            if (visited.contains(c))
                return c;
            else
                visited.add(c.val);
            c = c.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
       /* ListNode f = head, s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (f == s) break;
        }
        if (f == null) return null;

        while (f != head) {
            f = f.next;
            head = head.next;
        }*/
        return head;
    }
}
