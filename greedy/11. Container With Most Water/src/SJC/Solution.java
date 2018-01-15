package SJC;

/**
 * Created by SJC on 2018/1/9.
 */
public class Solution {
    public static int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        int n = len - 1;
        while (left <= right){
            if(height[left] < height[right]) {
                max = Math.max(max, height[left] * n);
                n--;
                left++;

            }else {
                max = Math.max(max,height[right] * n);
                n -- ;
                right --;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 23;a[1] = 3;a[2] = 64;
        System.out.println(maxArea(a));
    }
}
