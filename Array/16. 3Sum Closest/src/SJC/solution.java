package SJC;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by SJC on 2017/12/18.
 *
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class solution {
    //求数组中两个数的和最接近给定的k
    public static String twoSum(int a[],int k){
        Arrays.sort(a);
        int len = a.length;
        int res = Math.abs(a[0] + a[len-1] - k);
        int min1 = 0;
        int min2 = len-1;
        int i = 0;
        int j = a.length -1 ;
        while (i < j ){
            int sum = a[i] + a[j];
            if(Math.abs(sum - k) < res){
                res = Math.abs(sum - k);
                min1 = i;
                min2 = j;
            }
            if(a[i] + a[j] < k){
                i++;
            }else if (a[i] + a[j] == k) return "0";
            else j--;

        }
        String ans = min1 + ":" + min2 + " " + res;
        return ans;
    }
    //求数组中三个数的和最近接target
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = Math.abs(nums[0] + nums[1] + nums[len-1] - target);
        int ans = nums[0] + nums[1] + nums[len-1];
        for(int i = 0 ;i < len -2;i++){
            int next = i+1;
            int last = len -1;
            while (next < last){
                int sum = nums[i] + nums[next] + nums[last];
                if(res > Math.abs(sum - target)){
                    res = Math.abs(sum - target);
                    ans = sum;
                }
                if(sum > target){
                    last -- ;
                }else if(sum == target) return target;
                else next++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] a = {1,1,1,0};
        int target = -10;
        System.out.println(solution.threeSumClosest(a,target));
        System.out.println(Arrays.toString(a));
    }
}
