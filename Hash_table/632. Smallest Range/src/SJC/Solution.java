package SJC;

import java.util.*;

/**
 * Created by SJC on 2017/12/14.
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

 We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

 Example 1:
 Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 Output: [20,24]
 Explanation:
 List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 List 2: [0, 9, 12, 20], 20 is in range [20,24].
 List 3: [5, 18, 22, 30], 22 is in range [20,24].
 */
class Node implements Comparable<Node>{
    int row;
    int col;
    int val;
    public Node(int r,int c,int v){
        row = r;
        col = c;
        val = v;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getVal() {
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (row != node.row) return false;
        if (col != node.col) return false;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        result = 31 * result + val;
        return result;
    }
    public int compareTo(Node o){
        return this.val - o.val;
    }
}
public class Solution {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int ans [] = new int[2];
        int right = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        Queue<Node> queue = new PriorityQueue<>();
        int n = 0;
        for(List<Integer> ll : nums){
            queue.offer(new Node(n,0,ll.get(0)));
            right = Math.max(right,ll.get(0));
            n++;
        }
        ans[0] = queue.peek().getVal();
        ans[1] = right;
        left = queue.peek().getVal();
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.getCol() < nums.get(curr.getRow()).size() -1){
                queue.offer(new Node(curr.getRow(),curr.getCol()+1,nums.get(curr.getRow()).get(curr.getCol()+1)));
                right = Math.max(right,nums.get(curr.getRow()).get(curr.getCol()+1));
            }else {
                break;
            }
            left = queue.peek().getVal();
            range(ans,left,right);
        }
        return ans;
    }
    public static void range(int[] ans,int left,int right){
        if((ans[1] - ans[0]) > (right-left)){
            ans[0] = left;
            ans[1] = right;
            return;
        }
        if(ans[1] - ans[0] == (right - left)){
            if(left < ans[0]){
                ans[0] = left;
                ans[1] = right;
                return;
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        //4,10,15,24,26]
        ll.add(4);
        ll.add(10);
        ll.add(15);
        ll.add(24);
        ll.add(26);
        List<Integer> la = new ArrayList<>();
        la.add(0);
        la.add(9);
        la.add(12);
        la.add(20);
        List<Integer> lb = new ArrayList<>();
        lb.add(5);
        lb.add(18);
        lb.add(22);
        lb.add(30);
        list.add(ll);
        list.add(la);
        list.add(lb);
        int ans[] = Solution.smallestRange(list);
        System.out.println(Arrays.toString(ans));
    }
}
