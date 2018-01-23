package SJC;

/**
 * Created by SJC on 2018/1/21.
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        if(heights == null || heights.length == 0) return max;
        for(int i = 0;i < heights.length;i++){
            if(heights[i] == 0) continue;
            max = Math.max(max,heights[i]);
            int min = heights[i];
            int k = i + 1;
            if(min == 1) {
                while (k < heights.length &&  heights[k] == 1){
                    k++;
                }
                int mm = k;
                while (mm < heights.length && heights[mm] != 0){
                    mm ++;
                }
                max = Math.max(mm - i,max);
                i = k - 1;
                continue;
            }
            for(int j = i + 1;j < heights.length;j++){
                if(heights[j] == 0) break;
                min = Math.min(min,heights[j]);
                System.out.println("dd");
                System.out.println(j + " " + i);
                max = Math.max(max,min * (j - i + 1));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] heights = {1,3,2,1,2,1};
        System.out.println(largestRectangleArea(heights));
    }
}
