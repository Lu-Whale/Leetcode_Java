package Problem_List;

import java.util.HashSet;

public class _82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<Integer> store = new HashSet<>();
        HashSet<Integer> cache = new HashSet<>();

        ListNode pointer = head;
        while (pointer != null) {
            if(cache.contains(pointer.val)){
                store.add(pointer.val);
            }else {
                cache.add(pointer.val);
            }
            pointer = pointer.next;
        }

        ListNode previous = new ListNode(-1, head);
        ListNode newHead = previous;
        pointer = head;
        while (pointer != null) {
            if(store.contains(pointer.val)){
                previous.next = pointer.next;
            }else {
                previous = pointer;
            }
            pointer = pointer.next;
        }

        return newHead.next;
    }

    public ListNode deleteDuplicates_Sorted(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}