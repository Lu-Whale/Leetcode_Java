package Top_Interview_150.Linked_List;

import java.util.ArrayList;
import java.util.List;

public class _25_Reverse_Nodes_in_k_Group {
    public static ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> subHeads = new ArrayList<>();

        while (head != null) {
            ListNode subHead = head;
            int length = 1;
            while (head != null && length < k) {
                head = head.next;
                length++;
            }

            if(head == null) {
                subHeads.add(subHead);
            }else {
                ListNode nextHead = head.next;
                head.next = null;

                ListNode prev = null;
                while (subHead != null) {
                    ListNode next = subHead.next;
                    subHead.next = prev;
                    prev = subHead;
                    subHead = next;
                }
                subHeads.add(prev);
                head = nextHead;
            }
        }

        ListNode res = subHeads.get(0);
        for(int i = 0; i < subHeads.size(); i++) {
            ListNode tail = subHeads.get(i);
            while (tail.next != null) {
                tail = tail.next;
            }
            if(i < subHeads.size() - 1) tail.next = subHeads.get(i+1);
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        int k = 3;
        reverseKGroup(head, k);
    }
}
