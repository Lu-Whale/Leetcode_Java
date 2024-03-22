package Daily_Question;

public class _234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next !=null) {
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

        while (prev != null) {
            if(prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }

        return true;
    }
}
