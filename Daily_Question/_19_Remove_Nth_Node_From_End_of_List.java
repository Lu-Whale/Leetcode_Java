package Daily_Question;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class _19_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            length++;
        }
        if(n == length) return head.next;

        pointer = head;
        for(int i = 1; i < length - n; i++) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;

        return head;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head.next;
        int i = 1;
        while(right != null){
            right = right.next;
            // This ensures that there is a fixed gap of n nodes between left and right.
            if (i > n){ // when i > n, the left pointer start to move
                left = left.next;
            }
            i++;
        }

        if(i==n){
            return head.next;
        }

        left.next = left.next.next;
        return head;
    }
}