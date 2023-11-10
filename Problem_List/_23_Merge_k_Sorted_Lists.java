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

}
// https://leetcode.com/problems/merge-k-sorted-lists/solutions/10528/a-java-solution-based-on-priority-queue/
public class _23_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<>() {

            /**
             * Compares its two arguments for order.  Returns a negative integer,
             * zero, or a positive integer as the first argument is less than, equal
             * to, or greater than the second.<p>
             * <p>
             * The implementor must ensure that {@code sgn(compare(x, y)) ==
             * -sgn(compare(y, x))} for all {@code x} and {@code y}.  (This
             * implies that {@code compare(x, y)} must throw an exception if and only
             * if {@code compare(y, x)} throws an exception.)<p>
             * <p>
             * The implementor must also ensure that the relation is transitive:
             * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
             * {@code compare(x, z)>0}.<p>
             * <p>
             * Finally, the implementor must ensure that {@code compare(x, y)==0}
             * implies that {@code sgn(compare(x, z))==sgn(compare(y, z))} for all
             * {@code z}.<p>
             * <p>
             * It is generally the case, but <i>not</i> strictly required that
             * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
             * any comparator that violates this condition should clearly indicate
             * this fact.  The recommended language is "Note: this comparator
             * imposes orderings that are inconsistent with equals."<p>
             * <p>
             * In the foregoing description, the notation
             * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
             * <i>signum</i> function, which is defined to return one of {@code -1},
             * {@code 0}, or {@code 1} according to whether the value of
             * <i>expression</i> is negative, zero, or positive, respectively.
             *
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return a negative integer, zero, or a positive integer as the
             * first argument is less than, equal to, or greater than the
             * second.
             * @throws NullPointerException if an argument is null and this
             *                              comparator does not permit null arguments
             * @throws ClassCastException   if the arguments' types prevent them from
             *                              being compared by this comparator.
             */
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

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
