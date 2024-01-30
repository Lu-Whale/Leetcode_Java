package Top_Interview_150.Linked_List;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138_Copy_List_with_Random_Pointer {
    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        if(!hashMap.containsKey(head)) {
            Node newHead = new Node(head.val);
            hashMap.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }

        return hashMap.get(head);
    }
}
