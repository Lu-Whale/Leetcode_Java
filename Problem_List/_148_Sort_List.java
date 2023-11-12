package Problem_List;

//https://leetcode.com/problems/sort-list/
public class _148_Sort_List {
    public ListNode sortList(ListNode head) {
        // when list contain no more than one node
        if(head == null || head.next == null) {
            return head;
        }

        // Divide
        ListNode slowPointer = head, fastPointer = head.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode head2 = slowPointer.next;
        slowPointer.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        //Conquer
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        while (left != null && right != null) {
            if(left.val > right.val) {
                tail.next = right;
                right = right.next;
            }else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }

        tail.next = left == null ? right : left;

        return fakeHead.next;
    }
}
