package SJC;

/**
 * Created by SJC on 2018/1/15.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class Solution {
    public static  boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int currentIndex = 0;
        int lastIndex = 0;
        for(int i = 0;i < nums.length;i++){
            if(i > currentIndex) return false;
            currentIndex = Math.max(currentIndex,i + nums[i]);
            if(lastIndex == i){
                lastIndex = currentIndex;
//                i = currentIndex;
            }
        }
        return true;
    }
    //better
    public boolean canJump(int A[], int n) {
        int last=n-1,i,j;
        for(i=n-2;i>=0;i--){
            if(i+A[i]>=last)last=i;
        }
        return last<=0;
    }
    public static void main(String[] args) {

    }
}
