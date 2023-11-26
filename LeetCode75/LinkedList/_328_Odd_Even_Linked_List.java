package LeetCode75.LinkedList;

public class _328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();

        boolean isOdd = true;

        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            if(isOdd) {
                oddTail.next = current;
                oddTail = oddTail.next;
            }else {
                evenTail.next = current;
                evenTail = evenTail.next;
            }
            current = next;
            isOdd = !isOdd;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;

//        // 分别定义奇偶链表的 虚拟头结点 和 尾结点
//        ListNode oddHead = new ListNode();
//        ListNode oddTail = oddHead;
//        ListNode evenHead = new ListNode();
//        ListNode evenTail = evenHead;
//        // 遍历原链表，根据 isOdd 标识位决定将当前结点插入到奇链表还是偶链表（尾插法）
//        boolean isOdd = true;
//        while (head != null) {
//            if (isOdd) {
//                oddTail.next = head;
//                oddTail = oddTail.next;
//            } else {
//                evenTail.next = head;
//                evenTail = evenTail.next;
//            }
//            head = head.next;
//            isOdd = !isOdd;
//        }
//        // 将奇链表后面拼接上偶链表，并将偶链表的next设置为null
//        oddTail.next = evenHead.next;
//        evenTail.next = null;
//        return oddHead.next;
    }
}
