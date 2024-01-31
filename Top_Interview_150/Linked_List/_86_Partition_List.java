package Top_Interview_150.Linked_List;

import java.util.List;

public class _86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode largeHead = new ListNode();

        ListNode smallPointer = smallHead;
        ListNode largePointer = largeHead;

        while (head != null) {
            if(head.val < x) {
                smallPointer.next = head;
                head = head.next;
                smallPointer = smallPointer.next;
                smallPointer.next = null;
            }else {
                largePointer.next = head;
                head = head.next;
                largePointer = largePointer.next;
                largePointer.next = null;
            }
        }
        smallPointer.next = largeHead.next;
        return smallHead.next;
    }
}
