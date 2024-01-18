package Problem_List;

public class _92_Reverse_Linked_List_II {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int n = right - left + 1;
        ListNode reverseHead = head;
        ListNode pointer = head;
        int[] values = new int[n];
        for(int i = 1; i <= right; i++){
            if(i == left){
                reverseHead = pointer;
            }
            if(i >= left) {
                values[i - left] = pointer.val;
            }
            pointer = pointer.next;
        }
        for(int i = n - 1; i >= 0; i--){
            reverseHead.val = values[i];
            reverseHead = reverseHead.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseBetween(head, 2, 4);
    }
}
