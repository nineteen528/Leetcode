package SJC;

/**
 * Created by SJC on 2017/12/23.
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Solution {
    public static int findDuplicate(int[] nums) {
        int low = 1,high = nums.length-1;
        int middle = (low + high) / 2;
        while (low <= high){
            middle = (low + high) / 2;
            int count = 0;
            for(int n : nums){
                if(n <= middle){
                    count++;
                }
            }
            if(count <= middle){
                low = middle + 1;
            }else{
                high = middle-1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,7,6,1};
        System.out.println(findDuplicate(a));
    }
    //better
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}
