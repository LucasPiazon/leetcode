package list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode getListNode() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        return n1;
    }
}
