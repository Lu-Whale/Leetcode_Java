package Daily_Question;

public class _1669_Merge_In_Between_Linked_Lists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = list1;
        ListNode bNode = list1;

        for(int i = 0; i <= b; i++){
            if(i == a - 1){
                aNode = bNode;
            }
            bNode = bNode.next;
        }

        ListNode tail = list2;
        while (tail.next != null){
            tail = tail.next;
        }

        aNode.next = list2;
        tail.next = bNode;

        return list1;
    }
}
