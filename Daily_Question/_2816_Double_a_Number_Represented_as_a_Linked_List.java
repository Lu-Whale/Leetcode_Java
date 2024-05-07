package Daily_Question;

public class _2816_Double_a_Number_Represented_as_a_Linked_List {
    public ListNode doubleIt(ListNode head) {
        ListNode temp = reverse(head);

        ListNode pointer = temp;
        int flag = 0;
        while (pointer != null) {
            int num = 2 * pointer.val + flag;
            pointer.val = num % 10;
            flag = num / 10;
            pointer = pointer.next;
        }
        temp = reverse(temp);
        return flag == 1 ? new ListNode(1, temp) : temp;
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

class Solution_2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;

        ListNode left = head1;
        ListNode right = head;
        while (right != null) {
            if (right.val * 2 >= 10) {
                left.val += 1;
            }
            right.val = (right.val * 2) % 10;
            left = left.next;
            right = right.next;
        }
        return head1.val > 0 ? head1 : head;
    }
}
