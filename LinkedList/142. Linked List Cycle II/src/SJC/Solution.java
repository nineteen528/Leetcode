package SJC;

/**
 * Created by SJC on 2017/12/24.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
public class Solution {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode L1 = head,L2 = head;
        ListNode temp = null;
        while (L1 != null && L2 != null){
            L1 = L1.next;
            if(L2.next == null) return null;
            L2 = L2.next.next;
            if(L1 == L2){
                temp = L1;
                break;
            }
        }
        if(temp == null) return null;
        L1 = head;;
        while (L1 != L2){
            L1 = L1.next;
            L2 = L2.next.next;
        }
        return L1;
    }
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h1;
        ListNode a = detectCycle(h1);
        System.out.println(a.val);
        System.out.println(a.next.val);
    }
}
