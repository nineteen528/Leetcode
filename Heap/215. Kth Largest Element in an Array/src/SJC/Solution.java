package SJC;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by SJC on 2018/1/23.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Solution {
    public static int findKthLargest(int[] nums,int k){
        if(nums == null || k > nums.length) return 0;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        k = nums.length - k;
        for(int i = 0;i < k;i++) queue.add(nums[i]);
        for(int i = k;i < nums.length;i++){
            if(nums[i] < queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
    //划分
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int p = nums[start + (end - start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && nums[i] < p) {
                i++;
            }
            while (i <= j && nums[j] > p) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if (k <= j) {
            return quickSelect(nums, start, j, k);
        } else if (k >= i) {
            return quickSelect(nums, i, end, k);
        }
        return nums[k];
    }
    public static void main(String[] args) {

    }
}
