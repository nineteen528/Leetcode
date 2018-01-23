package SJC;

import java.util.List;
import java.util.prefs.NodeChangeEvent;

/**
 * Created by SJC on 2018/1/10.
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x ;
    }
}
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(n <= 0) return head;
        int num = 0;
        ListNode tmp = head;
        ListNode target = head;
        while (tmp.next != null){
            tmp = tmp.next;
            num++;
            if(num > n){
                target = target.next;
            }
        }
        if(tmp.next == null && num < n - 1) return head;
        if(tmp.next == null && num == n -1) return head.next;
        ListNode node = target.next.next;
        target.next = node;
        return head;
    }
    //better
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && n > 0) {
            cur = cur.next;
            n--;
        }
        ListNode tmp = dummy;
        while(cur.next != null) {
            tmp = tmp.next;
            cur = cur.next;
        }
        tmp.next = tmp.next.next;
        return dummy.next;
    }
    */
    public static void main(String[] args) {
        ListNode l1= new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l1.next = l2;
        l2.next = l;
        l.next =  l3;
        l3.next = l4;
        l4.next = null;
        ListNode t = removeNthFromEnd(l1,2);
        while (t != null){
            System.out.printf(" " + t.val);
            t = t.next;
        }
    }
}
