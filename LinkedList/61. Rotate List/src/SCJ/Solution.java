package SCJ;

/**
 * Created by SJC on 2018/1/17.
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 */
class ListNode{
    int va;
    ListNode next;
    ListNode(int va){
        this.va = va;
    }
}
public class Solution {
    public static ListNode diandao(ListNode head,int k){
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = dummy.next;
        ListNode tail = null;
        while (n1 != null) {
            if(n1.next == null) tail = n1;
            n1 = n1.next;
            len++;
        }
        k = k % len;
        if(k == 0) return dummy.next;
        ListNode n2 = dummy;
        int num = 0;
        while (num < k){
            n2 = n2.next;
            num++;
        }
        ListNode n3 = dummy;
        while(n2.next != null){
            n2 = n2.next;
            n3 = n3.next;
        }
        ListNode ans = n3.next;
        n3.next = null;
        tail.next = dummy.next;
        return ans;
    }
    public static void reverse(ListNode head){
        if(head == null) return;
        ListNode dummy = new ListNode(0);
        ListNode n1 = head;
        dummy.next = head;
        ListNode node1 = dummy.next;
        ListNode pre = null;
        ListNode second = null;
        while (node1 != null && node1.next != null){
            second = node1.next;
            node1.next = pre;
            ListNode third = second.next;
            second.next = node1;
            node1 = third;
            pre = second;
        }
        if(node1 == null){
            while (second != null) {
                System.out.println(second.va);
                second = second.next;
            }
            return;
        }
        if(node1.next == null){
            node1.next = second;
            while (node1 != null){
                System.out.println(node1.va);
                node1 = node1.next;
            }
            return ;
        }
    }
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(0);
        ListNode ln2 = new ListNode(1);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(3 + 1);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ln6.next = null;
        ln5.next = ln6;
        ln4.next = ln5;
        ln3.next = ln4;
        ln2.next = ln3;
        ln1.next = ln2;
        ListNode res = diandao(ln1,11);
        while (res != null){
            System.out.printf(""+res.va);
            res = res.next;
        }
        //reverse(ln1);
    }
}
