package SJC;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by SJC on 2018/1/13.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    public static int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] ans = new int[len];
        ans[len - 1] = 0;
        int min_index = len - 2;
        int min_num = 1;
        for(int i = len - 2;i >= 0;i --){
            if(nums[i] >= len - i - 1){
                ans[i] = 1;
            }else{
                ans[i] = ans[i + 1] + 1;
                for(int j = 2; j <= nums[i];j++){
                    ans[i] = Math.min(ans[i],ans[i + j] + 1);
                }
            }
        }
        return ans[0];
//        int[] record = new int[len];
//        return helper(0,0,nums,record,len - 1);
    }
    private static int helper(int index,int sum,int[] nums,int[] record,int len){
        if(index >=len) return sum;
        if(index + nums[index] >= len) return sum + 1;
        if(record[index] != 0) return record[index];
        int min = Integer.MAX_VALUE;
        for(int i = 1;i <= nums[index];i++){
            min = Math.min(min,helper(index + i,sum + 1,nums,record,len));
        }
        return record[index] = min;
    }
    //better O(n)
    public int jump2(int[] A) {                         //从前向后遍历一遍，每次尽量走得更远
        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i=0; i<A.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+A[i]);
            if( i == last_jump_max ) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        long s1 = System.currentTimeMillis();
        System.out.println(jump(nums));
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
    }
}
