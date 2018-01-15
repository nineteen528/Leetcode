package SJC;

/**
 * Created by SJC on 2017/12/21.
 */
public class Solution {
    public static int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int len = nums.length,sum = 0;
        for(int i = 0; i< len;i++){
            sum += nums[i];
        }
        if(sum - nums[0] ==0) return 0;
        //if(sum - nums[len-1] == 0) return len-1;
        int left = 0;
        System.out.println(sum);
        for(int i = 1;i < len -1;i++){
            left += nums[i -1];
            System.out.println(i+" "+left);
            if(left == sum - left - nums[i]){
                return i;
            }
        }
        if(sum - nums[len-1] == 0) return len-1;
        return -1;
    }
    //same
    public int pivotIndex2(int[] nums) {
        if(nums == null || nums.length < 1)
            return -1;
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }
        int left = 0;
        int right = sum - nums[0];
        int i = 0;
        while(i < nums.length) {
            if(left == right)
                return i;
            left += nums[i];
            i++;
            if(i < nums.length)
                right -= nums[i];

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {-1,-1,1,1,0,0};
        System.out.println(pivotIndex(a));
    }
}
