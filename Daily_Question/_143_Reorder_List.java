package Daily_Question;

public class _143_Reorder_List {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        boolean flag = true;
        ListNode pointer = new ListNode(0);
        while (head != null && prev != null) {
            if(flag) {
                pointer.next = head;
                head = head.next;
            }else {
                pointer.next = prev;
                prev = prev.next;
            }
            pointer = pointer.next;
            pointer.next = null;
            flag = !flag;
        }
    }
}
