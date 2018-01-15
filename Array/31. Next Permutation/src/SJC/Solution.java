package SJC;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by SJC on 2018/1/11.
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Solution {
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(nums[len -1 ]);
        for(int i = len - 1;i >= 1;i --){
            if(nums[i - 1] >= nums[i]){
                queue.add(nums[i - 1]);
            }else {
                int j = i ;
                //Queue<Integer> Q = new PriorityQueue<>(queue);
                while (queue.peek() <= nums[i - 1]){
                    nums[j++] = queue.poll();
                }
                int val = nums[i - 1];
                nums[i - 1] = queue.peek();
                queue.poll();
                queue.add(val);
                for(;j < len;j++){
                    nums[j] = queue.poll();
                }
                break;
            }
        }
        if(queue.size() == len){
            int i = 0;
            while (!queue.isEmpty()){
                nums[i++] = queue.poll();
            }
        }
        return;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
