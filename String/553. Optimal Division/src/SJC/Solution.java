package SJC;

/**
 * Created by SJC on 2018/1/3.
 */
public class Solution {
    public static String optimalDivision(int[] nums) {
        if(nums.length == 1) {
            return nums[0]+"";
        }
        if(nums.length == 2){
            return "" + nums[0] + "/" + nums[1];
        }
        String ans = nums[0] + "/(" + nums[1];
        for(int i = 2;i < nums.length;i++){
            ans += "/" + nums[i];
        }
        ans += ")";
        return ans;
    }

    public static void main(String[] args) {

    }
}
