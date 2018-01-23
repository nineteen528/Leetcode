package SJC;

import java.util.LinkedList;

/**
 * Created by SJC on 2018/1/4.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public static  ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if(k == 1) return head;
        ListNode tail = head;
        ListNode first = head.next;
        ListNode second = head;
        int count = 1;
        while (second != null && count < k ){
            if(second.next == null) break;
            second = second.next;
            count++;
        }
        if(count < k) return head;
        tail = second.next;
        ListNode pre = head;
        while (first != second){
            ListNode tmp = first;
            first = first.next;
            tmp.next = pre;
            pre = tmp;
        }
        second.next = pre;
        head.next = reverseKGroup(tail,k);
        return second;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        l2.next = null;
        ListNode head = reverseKGroup(l1,1);
        while (head != null){
            System.out.print(head.val);
            System.out.print("  ");
            head = head.next;
        }
    }
}
