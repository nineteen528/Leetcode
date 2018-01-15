package SJC;

import java.util.*;

/**
 * Created by SJC on 2017/12/27.
 *Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0,
 *
 */
public class Solution {
    public static  List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < len - 3;i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            for(int j = i+1;j < len - 2;j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                twoSum(ans,nums,target - nums[i] - nums[j],j+1,len-1,nums[i],nums[j]);
            }
        }
        return ans;
    }
    public static void twoSum(List<List<Integer>> ans,int[] nums,int target,int left,int right,int a,int b){
        while (left < right){
            if(nums[left] + nums[right] < target){
                int temp = left;
                left++;
                while (left <= right && nums[temp] == nums[left]){
                    left++;
                }
            }else if(nums[left] + nums[right] == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(a);temp.add(b);temp.add(nums[left]);temp.add(nums[right]);
                ans.add(temp);
                left++;
                right--;
            }else{
                int temp = right;
                right--;
                while (right >= left && nums[temp] == nums[right]){
                    right--;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {-5,-3,-2,0,0,4,4,5};
        int target = 4;
        List<List<Integer>> ans = fourSum(a,target);
        for(int i = 0; i < ans.size();i++){
            System.out.println(ans.get(i).toString());
        }
    }
}
