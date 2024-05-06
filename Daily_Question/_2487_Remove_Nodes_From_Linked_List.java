package Daily_Question;

public class _2487_Remove_Nodes_From_Linked_List {
    public ListNode removeNodes(ListNode head) {
        ListNode tempHead = reverse(head);

        ListNode curr = tempHead;
        ListNode pointer = tempHead.next;
        curr.next = null;
        int max = tempHead.val;
        while (pointer != null) {
            ListNode next = pointer.next;
            pointer.next = null;
            if(pointer.val >= max) {
                max = pointer.val;
                curr.next = pointer;
                curr = curr.next;
            }
            pointer = next;
        }

        return reverse(tempHead);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
