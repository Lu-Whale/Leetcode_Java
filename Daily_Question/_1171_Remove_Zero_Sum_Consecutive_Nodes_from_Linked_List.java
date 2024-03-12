package Daily_Question;

import java.util.*;

public class _1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    public static ListNode removeZeroSumSublists(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {

            //
            int sum = 0;
            int count = 0;
            boolean found = false;
            Iterator<ListNode> iterator = stack.descendingIterator();
            while (iterator.hasNext()) {
                sum += iterator.next().val;
                count++;
                if(sum == -head.val) {
                    found = true;
                    break;
                }
            }

            //
            if(found) {
                for(int i = 0; i < count; i++) {
                    stack.pollLast();
                }
            }else {
                if(head.val != 0) {
                    stack.offer(head);
                }
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        head = stack.pollFirst();
        ListNode pointer = head;
        while (!stack.isEmpty()){
            pointer.next = stack.pollFirst();
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(4)))));

        removeZeroSumSublists(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

class Solution_1171 {
    // Continuous intervals with a sum of 0---intervals with equal prefix sums
    public ListNode removeZeroSumSublists(ListNode head) {
        // Introduce a dummy head node to facilitate handling edge cases
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap<>();

        // Record the last occurrence of a node position with the same prefix sum
        int pre_sum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            pre_sum = pre_sum + curr.val;
            map.put(pre_sum, curr);
        }

        // The sum of elements within intervals with equal prefix sums is 0
        pre_sum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            pre_sum = pre_sum + curr.val;
            // Find a node with the same current prefix sum
            //
            // If found: If it's not the current position, it means the sum of the interval between
            // the current node and the node found in the map is 0, and that segment of nodes is removed
            //
            // If not found: It's still the current position, equivalent to curr.next = curr.next;
            curr.next = map.get(pre_sum).next;
        }

        return dummy.next;
    }
}
