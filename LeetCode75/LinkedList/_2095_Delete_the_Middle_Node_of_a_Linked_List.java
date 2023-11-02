package LeetCode75.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() { }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class _2095_Delete_the_Middle_Node_of_a_Linked_List {
    public ListNode mySolution(ListNode head) {

        int size = 1;

        // got the size of list
        ListNode tmp = head;
        while (tmp.next != null) {
            size++;
            tmp = tmp.next;
        }

        if(size == 1) {
            return null;
        }
        // got the middleIndex
        int middleIndex = size / 2;

        //find the previous node of middleIndex
        ListNode previousNode = head;
        int index = 0;
        while (index < middleIndex - 1) {
            previousNode = previousNode.next;
            index++;
        }

        if(previousNode.next.next !=null) {
            previousNode.next = previousNode.next.next;
        }else {
            previousNode.next = null;
        }

        return head;
    }

    // use two pointer, fast pointer is two times faster than slow pointer
    // when fast reaches the end of the list, slow will be positioned just before the middle node of the list.
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }

}

