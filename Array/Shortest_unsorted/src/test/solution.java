package test;

import java.util.Arrays;

/**
 * Created by sjc on 2017/6/5.
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 *
 *
 */
public class solution {
    public static int findUnsortedSubarray(int[] nums){
        int left=0,right=nums.length-1;
        int temp[]=nums.clone();
        Arrays.sort(temp);
        for( ;left<nums.length&&temp[left]==nums[left];left++){
        }
        for( ;right>=0&&temp[right]==nums[right];right--){
        }
        return left==nums.length ? 0:right-left+1;
    }
    public static void main(String[] args){
        int a[]=new int[5];
        a[0]=1;a[1]=5;a[2]=3;a[3]=2;a[4]=4;
        System.out.println(solution.findUnsortedSubarray(a));
    }
}
