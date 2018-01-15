package MC;

import java.util.*;

/**
 * Created by SJC on 2017/12/14.
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 */
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {   //priorityQueue remove (_)
        if(k == 0){
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1-o2);
            }
        });
        int len = nums.length;
        int [] ans = new int[len - k +1];
        int count = 0;
        for(int i = 0 ;i < len;i++){
            if(i < k){
                queue.offer(nums[i]);
                if(i == k-1){
                    ans[count++] = queue.peek();
                }
            }else{
                queue.remove(nums[i-k]);
                queue.offer(nums[i]);
                ans[count++] = queue.peek();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] list = {1,3,1,2,2,3};
        int k = 3;
        int ans [] = maxSlidingWindow2(list,k);
        System.out.println(Arrays.toString(ans));
    }
    //time less Solution
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(k == 0) return new int[0];
        int left = 0;
        int right = k;
        int index = 0;
        int pre_index = -1;
        int max = Integer.MIN_VALUE;
        int [] ans = new int[nums.length - k + 1];
        int len = nums.length;
        while (right <= len){
            if(left <= pre_index && pre_index < right){
                if(nums[right-1] > nums[pre_index]){
                    pre_index = right - 1;
                    max = nums[right - 1];
                }
            }else {
                max = Integer.MIN_VALUE;
                for(int i = left;i < right;i++){
                    if(nums[i] > max){
                        max = nums[i];
                        pre_index = i;
                    }
                }
            }
            ans[index++] = max;
            left++;
            right++;
        }
        return ans;
    }
    //Deque
    public static int[] maxSlidingWindow3(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
