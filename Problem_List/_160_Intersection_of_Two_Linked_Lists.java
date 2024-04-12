package Problem_List;

import java.util.HashSet;

public class _160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (headB != null) {
            hashSet.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            if(hashSet.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
