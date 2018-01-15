package SJC;

import java.util.*;

/**
 * Created by SJC on 2017/12/14.
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Median
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 */
public class Solution {
    static Queue<Integer> maxHeap = new PriorityQueue<>();
    static Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -(o1 - o2);
        }
    }) ;
    public static double[] medianSlidingWindow(int[] nums, int k){
        int len = nums.length;
        if(len - k +1 <= 0 ) return new double[0];
        double [] ans = new double[len - k + 1];
        for(int i = 0;i <= len;i++){
            if(i >= k){
                ans[i-k] = findMedian(maxHeap,minHeap);
                remove(nums[i - k]);
            }
            if(i < nums.length){
                add(nums[i]);
            }
        }
        return ans;
    }
    public static double findMedian(Queue<Integer> maxHeap,Queue<Integer> minHeap){
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;
        return maxHeap.size() > minHeap.size() ? (double)maxHeap.peek() : ((double)maxHeap.peek()+(double)minHeap.peek())/2.0;
    }
    public static void add(int k){
        minHeap.offer(k);
        maxHeap.offer(minHeap.poll());
        if((maxHeap.size() - 1) > minHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
        /*
        if (k < findMedian(maxHeap,minHeap)) {
            minHeap.add(k);
        }
        else {
            maxHeap.add(k);
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        */
    }
    public static void remove(int k){
        if(k < findMedian(maxHeap,minHeap)){
            minHeap.remove(k);
        }else {
            maxHeap.remove(k);
        }
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size() - minHeap.size() >1){
            minHeap.offer(maxHeap.poll());
        }
    }
    public static void main(String[] args) {
        int [] nums = {214783647,214783647};
        System.out.println(Integer.MAX_VALUE);
        int k = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums,2)));
    }
}
