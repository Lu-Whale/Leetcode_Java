package Problem_List;

//https://leetcode.com/problems/sort-list/
public class _148_Sort_List {
    public ListNode sortList(ListNode head) {
        // if the list is less or equal than one node, then return
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slowPointer = head, fastPointer = head.next;

        // Divide the list
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode head2 = slowPointer.next;
        slowPointer.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        // Conquer
        ListNode tmphead = new ListNode(0);
        ListNode res = tmphead;

        while (left != null && right != null) {
            if(left.val < right.val) {
                tmphead.next = left;
                left = left.next;
            }else {
                tmphead.next = right;
                right = right.next;
            }
            tmphead = tmphead.next;
        }
        // add the rest node to the list
        tmphead.next = left != null ? left : right;

        return res.next;
    }
}
