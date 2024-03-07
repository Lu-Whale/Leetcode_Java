package Top_Interview_150.Linked_List;

public class _21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fakeHead = new ListNode();
        ListNode pointer = fakeHead;

        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                pointer.next = list1;
                list1 = list1.next;

            }else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        pointer.next = list1 == null ? list2 : list1;

        return fakeHead.next;
    }
}
