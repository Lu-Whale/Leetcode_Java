package Top_Interview_150.Linked_List;

public class _19_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }
        if(length == 1) {
            return null;
        }
        if(length == n) {
            return head.next;
        }

        int k = length - n;
        pointer = head;
        for(int i = 1; i < k; i++) {
            pointer = pointer.next;
        }

        pointer.next = n == 1 ? null : pointer.next.next;

        return head;
    }
}
