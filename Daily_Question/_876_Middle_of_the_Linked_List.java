package Daily_Question;

public class _876_Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}

