package Problem_List;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
// https://leetcode.com/problems/merge-k-sorted-lists/solutions/10528/a-java-solution-based-on-priority-queue/
public class _23_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for(ListNode head: lists) {
            if(head != null) {
                priorityQueue.add(head);
            }
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;

            if(tail.next != null) {
                priorityQueue.add(tail.next);
            }
        }

        return head.next;

    }
}
