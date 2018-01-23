package SJC;

import java.util.List;

/**
 * Created by SJC on 2018/1/10.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class Solution {
    public static ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = helper(head);
        return dummy.next;
//        ListNode current = dummy;
//        while(current.next != null && current.next.next != null){
//               ListNode first = current.next;
//               ListNode sec = current.next.next;
//               first.next =sec.next;
//               sec.next =first;
//               current.next = sec;
//               current = first;
//        }
//        return dummy.next;
    }
    public static ListNode helper(ListNode head){
        if(head == null) return null;
        ListNode l1 = head;
        ListNode h2 = head.next;
        if(h2 == null) return l1;
        ListNode l3 = h2.next;
        h2.next = l1;
        l1.next = helper(l3);
        return h2;
    }
    public static void main(String[] args) {

    }
}
