package SJC;

/**
 * Created by SJC on 2018/1/16.
 */
public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        if(s <=0 || nums == null || nums.length == 0) return 0;
        int sum = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1- 1;i < nums.length;i++){
            if((sum = sum + nums[i]) >= s){
                System.out.println(sum);
                min = i - left + 1;
                if(min == 1) return 1;
                while(sum - nums[left] >= s){
                    sum -= nums[left];
                    left++;
                    min--;
                    if(min == 1) return 1;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    //better
    public int minSubArrayLen2(int s, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int result=nums.length+1;
        while(j<nums.length){
            sum+=nums[j++];
            while(sum>=s){
                result=Math.min(result,j-i);
                sum-=nums[i++];
            }
        }
        return result==nums.length+1?0:result;
    }
    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,a));
    }
}
