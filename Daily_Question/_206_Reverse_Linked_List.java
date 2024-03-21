package Daily_Question;

public class _206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

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
