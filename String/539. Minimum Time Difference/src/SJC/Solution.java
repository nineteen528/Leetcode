package SJC;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by SJC on 2018/1/3.
 */
public class Solution {
    public static int findMinDifference(List<String> timePoints) {
        if(timePoints.size() < 2) return -1;
        int len = timePoints.size();
        int[] nums = new int[len];
        int min = Integer.MAX_VALUE;
        nums[0] = transform(timePoints.get(0));
        for (int i = 1;i < len;i++){
            nums[i] = transform(timePoints.get(i));
        }
        Arrays.sort(nums);
        for (int i = 1;i < len;i++){
            min = Math.min(min,nums[i] - nums[i - 1]);
        }
        min = Math.min(min,nums[0] + 24*60 - nums[len - 1]);
        return min;
    }
    //better
    public int findMinDifference2(List<String> timePoints) {
        int buckets[] = new int[24*60];
        int min = 24*60, max = 0, res = 0;

        for (String time:timePoints){
            int minutes = transform(time);
            min = Math.min(minutes, min);
            max = Math.max(minutes, max);
            if (buckets[minutes] == 1) return 0;
            buckets[minutes] = 1;
        }

        res = 24 * 60 - (max - min);
        int last = min;

        for (int i = min+1; i <= max; i++){
            if (buckets[i] != 1) continue;
            res = Math.min(res, i - last);
            last = i;
        }

        return res;
    }
    public static int transform(String s){
        return Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3,5));
    }
    public static void main(String[] args) {
        String s = "01:60";
        System.out.println(transform(s));
    }
}
