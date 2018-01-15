package SJC;

/**
 * Created by SJC on 2017/12/23.
 */
class ListNode {
     int val;
     ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode l3 = new ListNode((l1.val + l2.val) % 10 );
        flag = (l1.val + l2.val) / 10;
        l1 = l1.next;l2 = l2.next;
        ListNode temp = l3;
        while (l1 != null && l2!= null){
            temp.next = new ListNode((l1.val + l2.val + flag)%10);
            flag = (l1.val + l2.val + flag) / 10;
            temp = temp.next;
            l1 = l1 .next;
            l2 = l2.next;
        }
        int count = 0;
        while (l1 != null){
            temp.next = new ListNode( (l1.val + flag) % 10);
            flag = (l1.val + flag) / 10;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null){
            temp.next = new ListNode( (l2.val + flag) % 10);
            flag = (l2.val + flag) / 10;
            temp = temp.next;
            l2= l2.next;
        }
        if(flag == 1){
            temp.next = new ListNode(1);
            temp = temp.next;
        }
        temp.next = null;
        return l3;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode result = new ListNode(0);
        ListNode cur = result;

        int carry = 0;

        while (null != cur1 || null != cur2 || 1 == carry) {
            int sum = (null == cur1? 0 : cur1.val) + (null == cur2? 0 : cur2.val) + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            cur1 = (null == cur1) ? null : cur1.next;
            cur2 = (null == cur2) ? null : cur2.next;
        }
        return result.next;
    }
    public static void main(String[] args) {
        ListNode L1 = new ListNode(2);
        ListNode L2 = new ListNode(4);
        ListNode L3 = new ListNode(3);
        L1.next = L2;
        L2.next = L3;
        L3.next = null;

        ListNode LL1 = new ListNode(5);
        ListNode LL2 = new ListNode(6);
        ListNode LL3 = new ListNode(4);
        LL1.next = LL2;
        LL2.next = LL3;
        LL3.next = null;

        ListNode LLL3 = addTwoNumbers(L1,LL1);
        while (LLL3 !=null){
            System.out.println(LLL3.val + " ");
            LLL3 = LLL3.next;
        }
    }
}
