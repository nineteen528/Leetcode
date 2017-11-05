package test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sjc on 2017/6/26.
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 Example 1:
 Input: [2,2,3,4]
 Output: 3
 Explanation:
 Valid combinations are:
 2,3,4 (using the first 2)
 2,3,4 (using the second 2)
 2,2,3
 */
public class solution {
    public static int triangleNumber(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0) continue;
            for(int j=i+1;j<nums.length-1;j++){
               for(int k=j+1;k<nums.length;k++){
                   if(nums[i]+nums[j]>nums[k]) res++;
                   else break;
               }
            }
        }
        return res;
    }
    /* 优质解
    public static int aa(int[] nums){
        int res=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            int j=0;
            int k=i-1;
            while(j<k){
                if(nums[k]+nums[j]>nums[i]){
                    res+=k-j;
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }*/
    /*also ok
    public static int aa(int[] nums){
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=i+2;
            while (k< nums.length){
                if(nums[i]+nums[j]>nums[k]){
                    res+=k-j;
                    k++;
                }else{
                    j++;
                    if(j==k){
                        k++;
                    }
                }
            }
        }
        return res;
    }
    */
    public static void main(String[] args){
        int a[]={2,2,3,4};
        System.out.println(solution.triangleNumber(a));
    }
}
