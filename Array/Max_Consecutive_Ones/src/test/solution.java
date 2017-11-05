package test;

/**
 * Created by sjc on 2017/7/11.
 * Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 */
public class solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int temp=0;
            while (nums[i]==1){
                i++;
                temp++;
                if(i==nums.length){
                    break;
                }
            }
            res=Math.max(res,temp);
            if(i==nums.length){
                break;
            }
            while(nums[i]==0){
                i++;
                if(i==nums.length){
                    break;
                }
            }
            if(i==nums.length){
                break;
            }
            if(nums[i]==1){
                i--;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int []a={1,1,0,1,1,1};
        System.out.println(solution.findMaxConsecutiveOnes(a));
    }
}
/*
public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int lastZero =-1;
        for(int i = 0; i<=nums.length; i++){
            if(i==nums.length || nums[i]==0){
                max = Math.max(i-lastZero-1, max);
                lastZero=i;
            }
        }
        return max;
    }
 */
