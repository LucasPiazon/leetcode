package list;

public class Q369 {
    static class Solution {
        public ListNode plusOne(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode headA = reverse(head);
            ListNode cur = headA;
            ListNode pre = null;
            int count = 1;
            while (count != 0) {
                if (cur == null) {
                    cur = new ListNode(count);
                    pre.next = cur;
                } else {
                    cur.val = (cur.val + count) % 10;
                }
                count = cur.val == 0 ? 1 : 0;
                pre = cur;
                cur = cur.next;
            }
            ListNode headB = reverse(headA);
            return headB;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new ListNode(9));
    }
}
