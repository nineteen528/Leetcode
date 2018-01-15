/**
 * Created by SJC on 2017/12/28.
 * Given an array and a value, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length
 */
public class Solution {
    public static int removeElement(int[] nums,int val){
        int len = nums.length;
        int ans = 0;

        for(int i = 0;i < len;i++){
            if(nums[i] != val){
                nums[ans++] = nums[i];
            }
        }
        for(int i = ans;i < len;i++){
            nums[i] = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 3;
        nums[1] = 2;
        nums[2] = 2;
        nums[3] = 3;
        int val = 3;
        System.out.println(removeElement(nums,val));
    }
}
