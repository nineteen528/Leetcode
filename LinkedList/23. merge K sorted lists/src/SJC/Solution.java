package SJC;

/**
 * Created by SJC on 2017/12/28.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Seen this question in a real interview before?  YesNo

 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwoLists(lists[0],lists[1]);
        return mergeRecursive(lists,0,lists.length);
    }
    public static ListNode mergeRecursive(ListNode[] lists,int left,int right){
        if(left == right) return lists[left];
        if(left > right) return null;
        int middle = (left + right) / 2;
        ListNode L = mergeRecursive(lists,left,middle);
        ListNode R = mergeRecursive(lists,middle+1,right);
        return mergeTwoLists(L,R);
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;

        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        ListNode ans = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;;
                head = head.next;
                l1= l1.next;
            }else {
                head.next = l2;
                head =head.next;
                l2 = l2.next;
            }
        }
        if (l1 != null){
            head.next = l1;
        }
        if (l2 != null){
            head.next = l2;
        }
        return ans ;
    }
    //better 写法
   /* public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode mergedResultPreHead = new ListNode(0);
        ListNode p = mergedResultPreHead;

        if (node1 == null && node2 == null) {
            return null;
        }

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }

        if (node1 != null) {
            p.next = node1;
        } else {
            p.next = node2;
        }

        return mergedResultPreHead.next;
    }*/
    public static void main(String[] args) {

    }
}
