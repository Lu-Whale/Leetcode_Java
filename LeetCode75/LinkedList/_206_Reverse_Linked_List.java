package LeetCode75.LinkedList;

import java.util.List;

// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class _206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            //store the next node
            ListNode next = current.next;
            //reverse
            current.next = previous;
            //move pointer
            previous = current;
            current = next;
        }
        // after iteration, the current will point to null and the previous will
        // point to the last node of original list, which is the head of new List
        return previous;
    }
}
