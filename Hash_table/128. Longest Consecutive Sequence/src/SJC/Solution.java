package SJC;

import java.util.*;

/**
 * Created by SJC on 2018/1/7.
 */
public class Solution {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int res = 1;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> record = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            set.add(nums[i]);
        }
//        System.out.println(set.size());
//        System.out.println(min + " " + max);
        Iterator<Integer> it = set.iterator();
        for(int i = 0;i < nums.length;i++){
            int val = nums[i];
            if(record.containsKey(val - 1)){
                record.put(val,record.get(val - 1) + 1);
                res = Math.max(res,record.get(val - 1) + 1);
                set.remove(val);
            }else {
                int tmp = val;
                while (tmp >= Integer.MIN_VALUE && (set.contains(tmp) || record.containsKey(tmp))){
                    if(record.containsKey(tmp)){
                        //System.out.println(count+" asdf"+val);
                        count += record.get(tmp);
                        break;
                    }
                    set.remove(tmp);
                    count++;
                    tmp--;
                    //System.out.println("hu" + tmp);
                }
               /// System.out.println("hh" + val +"    "+count);
                record.put(val,count);
                res = Math.max(res,count);
                count = 0;
            }
        }
        return res;
    }
    //better
    public int longestConsecutive2(int[] nums) {

        Set<Integer> numSet = new HashSet<Integer>();
        for(int n : nums) {
            numSet.add(n);
        }

        int maxLen = 0;

        while(numSet.size() > 0) {

            int n = numSet.iterator().next();
            numSet.remove(n);

            int currLen = 1;
            int left = n - 1;
            int right = n + 1;
            while(numSet.remove(left--)) {
                currLen++;
            }
            while(numSet.remove(right++)) {
                currLen++;
            }

            maxLen = Math.max(currLen, maxLen);
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int[] a ={-1,1,0};
        System.out.println(longestConsecutive(a));

    }
}
