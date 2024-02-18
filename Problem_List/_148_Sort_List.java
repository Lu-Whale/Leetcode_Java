package Problem_List;

//https://leetcode.com/problems/sort-list/
public class _148_Sort_List {
    public ListNode sortList(ListNode head) {
        // when list contain no more than one node
        if(head == null || head.next == null) {
            return head;
        }

        // Divide
        ListNode slowPointer = head, fastPointer = head.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode head2 = slowPointer.next;
        slowPointer.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(head2);

        //Conquer
        ListNode fakeHead = new ListNode(0);
        ListNode tail = fakeHead;
        while (left != null && right != null) {
            if(left.val > right.val) {
                tail.next = right;
                right = right.next;
            }else {
                tail.next = left;
                left = left.next;
            }
            tail = tail.next;
        }

        tail.next = left == null ? right : left;

        return fakeHead.next;
    }
}


class Solution_148_QuickSort {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head;

        int len = 0;

        while(head!=null){
            len++;
            head = head.next;
        }
        head = newHead;

        quickSort(head,0,len-1);

        return newHead;

    }

    private void quickSort(ListNode node, int low, int high){

        while(low<high){
            int pivotIdx = partition(node, low, high);

            quickSort(node, low, pivotIdx-1);
            quickSort(node, pivotIdx+1,high);
            return;
        }

    }

    private int partition(ListNode node, int low, int high) {
        int pivot = getPivotValue(node, high);

        for (int i = low; i < high; i++) {
            if (node.val > pivot) {
                int temp = node.val;
                node.val = pivot;
                pivot = temp;
            }
            node = node.next;
        }
        node.val = pivot;

        return high;
    }

    private int getPivotValue(ListNode node, int idx){
        while(idx--!=0){
            node = node.next;
        }
        return node.val;
    }
}

