package SJC;

import java.util.LinkedList;

/**
 * Created by SJC on 2018/1/4.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {val = x; }
}
public class Solution {
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode yy = head;
        while (yy != null){
            count++;
            if(yy.next == null) break;
            yy = yy.next;
        }
        return mergeList(head,yy);
    }
    public static ListNode mergeList(ListNode left,ListNode right){
        if(left == null) {
            return left;
        }
        if(left.next == null || left == right){
            left.next = null;
            return left;
        }
        int count = 0;
        ListNode yy = left;
        while (yy != right){
            count++;
            yy = yy.next;
        }
        ListNode middle  = left;
        int num = 0;
        //System.out.println(left.val + "     " + right.val + "       " + count) ;
        while (num < (count) / 2){
            middle = middle.next;
            num ++;
        }
        ListNode mm = middle.next;
        middle.next = null;
        ListNode l = mergeList(left,middle);
        ListNode r = mergeList(mm,right);
        return merge(l,r);
    }
    public static ListNode merge(ListNode L1 ,ListNode L2){
        if(L1 == null) return L2;
        if(L2 == null) return L1;
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (L1 != null && L2 != null){
            if(L1.val < L2.val){
                head.next = L1;
                L1 = L1.next;
            }else {
                head.next = L2;
                L2 = L2.next;
            }
            head = head.next;
        }
        if(L1 != null){
            head.next = L1;
        }
        if(L2 != null) {
            head.next = L2;
        }
        return ans.next;
    }
    //better  递归
    public ListNode sortList2(ListNode head) {
        //corner case
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow;
        slow = slow.next;
        pre.next = null; //这里注意要断掉，要不每次循环都是完整的队列

        head = sortList(head);
        slow = sortList(slow);

        //merge
        ListNode pin = new ListNode(0), dummy = pin;
        while(head != null && slow != null) {
            if(head.val < slow.val) {
                dummy.next = head;
                head = head.next;
            } else {
                dummy.next = slow;
                slow = slow.next;
            }
            dummy = dummy.next;
        }

        if(head != null)
            dummy.next = head;
        if(slow != null)
            dummy.next = slow;

        return pin.next;
    }

    //better 非递归
    /*
    private ListNode tail;
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) {
            tail = head;
            return head;
        }
        ListNode biggerListHead = null;
        ListNode smallerListHead = null;
        ListNode equalListHead = head;
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode next = node.next;
            if (node.val == head.val) {
                node.next = equalListHead;
                equalListHead = node;
            } else if (node.val > head.val) {
                node.next = biggerListHead;
                biggerListHead = node;
            } else {
                node.next = smallerListHead;
                smallerListHead = node;
            }
            node = next;
        }

        node = head;
        if (smallerListHead != null) {
            head = sortList(smallerListHead);
            tail.next = equalListHead;
        } else {
            head = equalListHead;
        }
        if (biggerListHead != null) {
            node.next = sortList(biggerListHead);
        } else {
            tail = node;
        }
        return head;
    }
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        //ListNode ans = mergeList(l1,l4);
        ListNode ans = sortList(l1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
