package SJC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SJC on 2018/1/20.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 */
public class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        if(k > n) return new ArrayList<>();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = i + 1;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        int sum = 0;
        helper(0,k,sum,visited,tmp,ans);
        return ans;
    }
    private static void helper(int index,int k,int sum,boolean[]visited,List<Integer> tmp,List<List<Integer>> ans){
        if(sum == k){
            ans.add(new LinkedList<>(tmp));
        }
        if(index == visited.length) return;
        for(int i = index;i < visited.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            tmp.add(i + 1);
            helper(i + 1,k,sum + 1,visited,tmp,ans);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = combine(4,2);
    }
}
