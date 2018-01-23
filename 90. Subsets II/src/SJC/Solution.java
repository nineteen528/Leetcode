package SJC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SJC on 2018/1/16.
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Solution {
    int a;
    Solution(int a){this.a = a;}
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if(nums == null || nums.length == 0) return ans;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        for (int i = 0;i < nums.length;i++){

            for(int j = 0;j < nums.length;j++){
                if(j > 0 && nums[j - 1] == nums[j]){
                    continue;
                }
                Arrays.fill(visit,false);
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[j]);
                visit[j] = true;
                helper(nums,visit,j + 1,1,i + 1,tmp,res);
            }
        }
        return res;
    }
    private static void helper(int[] nums,boolean[] visited,int index,int sum,int k,List<Integer> tmp,List<List<Integer>> res){
        if(sum == k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(index == nums.length) return;
        for(int i = index;i < nums.length;i++){
            if(visited[i] == true) continue;
            if(i > 0 && nums[i] == nums[i- 1] && visited[i - 1] == false) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            helper(nums,visited,i + 1,sum + 1,k,tmp,res);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] arrs = {1,2,3};
        for(List<Integer> ll : subsetsWithDup(arrs)){
            System.out.println(ll.toString());
        }

    }
}
