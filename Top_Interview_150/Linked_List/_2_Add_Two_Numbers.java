package Top_Interview_150.Linked_List;

// https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
public class _2_Add_Two_Numbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0;
        ListNode head = l1;
        while (l1 != null && l2 != null) {
            l1.val += l2.val + x;
            x = l1.val >= 10 ? 1: 0;
            l1.val %= 10;
            if(l1.next == null && l2.next == null & x == 1) {
                l1.next = new ListNode(0, null);
            }
            if(l1.next == null) {
                l1.next = l2.next;
                l1 = l1.next;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null && x == 1) {
            l1.val += x;
            x = l1.val >= 10 ? 1: 0;
            l1.val %= 10;
            if(l1.next == null && x == 1) {
                l1.next = new ListNode(0, null);
            }
            l1 = l1.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));


        ListNode res = addTwoNumbers(l1, l2);
        System.out.println("-------");
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}