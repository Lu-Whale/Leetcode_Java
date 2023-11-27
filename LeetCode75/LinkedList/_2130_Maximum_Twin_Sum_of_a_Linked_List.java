package LeetCode75.LinkedList;

import java.util.WeakHashMap;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class _2130_Maximum_Twin_Sum_of_a_Linked_List {
    public int pairSum(ListNode head) {
        if(head == null) {
            return 0;
        }

        // find the middle node
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // break the list to two lists, where twinHead is the head of the second list
        ListNode twinHead = slowPointer.next;
        slowPointer.next = null;

        // Reverse the second list
        ListNode previous = null;
        ListNode current = twinHead;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        // after reversal, the previous is the new head of the second list,
        // to make it clear, let the twinHead pointer point to the new head
        twinHead = previous;
        // iterate two lists and find the max sum
        int res = 0;
        while (head != null) {
            res = Math.max(res, head.val + twinHead.val);
            twinHead = twinHead.next;
            head = head.next;
        }

        return res;
    }
}
