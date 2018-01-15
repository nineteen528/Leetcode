package SJC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by SJC on 2018/1/10.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Solution {
    public static  List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]){
                        j++;
                    }
                }else if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);tmp.add(nums[j]);tmp.add(nums[k]);
                    ans.add(tmp);
                    j++;
                    while (j < nums.length && nums[j] == nums[j - 1]){
                        j++;
                    }
                    k--;
                    while (k >= 0 && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else {
                    k--;
                    while (k >= 0 && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
    public static  List<List<Integer>> threeSumRecursive(int[] nums){     //都归结发
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        List<Integer> a = new ArrayList<>();
        helper(0,0,0,3,visited,nums,a,ans);
        return ans;
    }
    public static void helper(int index,int sum,int target,int k,int[] visited,int[] nums,List<Integer> tmp,List<List<Integer>> ans){
        List<Integer> t = new ArrayList<>(tmp);
        if(k == 0 && sum == target){
            //System.out.println(tmp.toString());
            ans.add(t);
            return;
        }
        if(k == 0 && sum != target){
            return;
        }
        for (int i = index;i < nums.length;i++){
            if (i > index && nums[i] == nums[i - 1]) continue;
            if(visited[i] == 1) continue;
            visited[i] = 1;
            t.add(nums[i]);
            helper(i + 1,sum + nums[i],0,k - 1,visited,nums,t,ans);
            t.remove(t.size() - 1);
            visited[i] = 0;
        }
    }
    public static void main(String[] args) {
        int[] a ={-1,0,1,2,-1,-4};
        List<List<Integer>> al = threeSum(a);
        for(List<Integer> l : al){
            System.out.println(l.toString());
        }
        List<List<Integer>> bl = threeSumRecursive(a);
        for(List<Integer> l : bl){
           System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
