package Top_Interview_150.Linked_List;

public class _61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        int n = 0;
        ListNode pointer = head;
        while (pointer != null) {
            n++;
            pointer = pointer.next;
        }
        k %= n;
        if(k == 0) {
            return head;
        }
        ListNode newHead = head;
        ListNode tail = head;
        pointer = head;
        for(int i = 0; i < n; i++) {
            if(i == n - k - 1) {
                newHead = pointer.next;
                pointer.next = null;
                pointer = newHead;
            }else if(i == n - 1) {
                tail = pointer;
            }else {
                pointer = pointer.next;
            }
        }
        tail.next = head;


        return newHead;
    }
}
