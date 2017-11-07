package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SJC on 2017/11/5.
 * Your are given an array of positive integers nums.

 Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

 Example 1:
 Input: nums = [10, 5, 2, 6], k = 100
 Output: 8
 Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */
public class solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        long p = 1l;
        int i = 0;
        int j = 0;
        int total = 0;
        while(j < n){
            p *= nums[j];
            while(i <= j&&p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
            j++;
        }
        return total;
    }

    public static void main(String[] args) {
        int [] nums={10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k=19;
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }
}
