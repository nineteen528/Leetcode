package SJC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SJC on 2018/1/13.
 */
public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        int[] record = new int[nums.length];
        helper(nums,visit,0,record,ans);
        return ans;
    }
    public static void helper(int[] num,boolean[] visit,int k,int[] record,List<List<Integer>> ans){
        if(k == num.length){
            List<Integer> res = new ArrayList<>();
            for(int nu : record)
                res.add(nu);
            ans.add(res);
            return;
        }
        for(int i = 0;i < num.length;i++){
            if(visit[i] == true) continue;
            if(i > 0 && num[i] == num[i - 1] && !visit[i - 1] ) continue;
            visit[i] = true;
            record[k] = num[i];
            helper(num,visit,k + 1,record,ans);
            visit[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        List<List<Integer>> ans = permute(a);
        for(List<Integer> list : ans){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
