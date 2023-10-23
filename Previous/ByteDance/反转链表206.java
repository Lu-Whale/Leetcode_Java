package Previous.ByteDance;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class 反转链表206 {

    //要求返回一个listnode，那么就返回更新后的头节点就好了
    public ListNode reverseListIteration(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            previous = current;
            current.next = previous;
            current = next;
        }
        return previous;
    }

    public ListNode reverseListDFS(ListNode head) {
        //head == null 是头节点为空的情况
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListDFS(head.next);
        head.next.next = head;
        //n1的下一个节点必须指向null，否则会产生循环
        head.next = null;
        return newHead;
    }

}
