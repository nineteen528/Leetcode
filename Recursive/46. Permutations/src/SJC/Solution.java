package SJC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SJC on 2018/1/13.
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 */
public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
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
            visit[i] = true;
            record[k] = num[i];
            helper(num,visit,k + 1,record,ans);
            visit[i] = false;
        }
    }
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        DFSHelper(result, nums, 0);
        return result;
    }

    private void DFSHelper(List<List<Integer>> result, int[] nums, int index){
        if(index == nums.length){
            List<Integer> path = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                path.add(nums[i]);
            }
            result.add(path);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, index, i);
            DFSHelper(result, nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 0;
        a[2] = 2;
        List<List<Integer>> ans = permute(a);
        for(List<Integer> list : ans){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
