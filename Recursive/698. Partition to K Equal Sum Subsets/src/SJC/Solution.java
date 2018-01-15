package SJC;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SJC on 2018/1/8.
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:
 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */
public class Solution {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null) return false;
        if(k == 1) return true;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        if(sum % k != 0) return false;
        System.out.println(sum / k);
        boolean[] visited = new boolean[nums.length];
        System.out.println(k);
        return helper(nums,visited,k,0,sum / k,0);
    }
    public static boolean helper(int[] nums,boolean[] visit,int k,int sum,int target,int index){
        if(k == 0) return true;
        if(sum > target) return false;
        if(sum == target) return helper(nums,visit,k -1 ,0,target,0);
        for(int i = index;i < nums.length;i++){
            if(visit[i]) continue;
            visit[i] = true;
            if(helper(nums,visit,k,sum + nums[i],target,i + 1 )) return true;
            visit[i] = false;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int number = 2;
        System.out.println(canPartitionKSubsets(nums,number));
    }
}
