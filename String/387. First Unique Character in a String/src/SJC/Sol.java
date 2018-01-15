package SJC;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SJC on 2018/1/6.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 */
public class Sol {
    public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return  -1;
        if(s.length() == 1) return 0;
        int len = s.length();
        Map<Character,Integer> map = new HashMap<>(len * 2 - 1);
        //int[] record = new int[len];
        int[] record = new int[26];
        for(int i = 0;i < 26;i++){
            record[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i< len;i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                //record[i] = 1;
                record[s.charAt(i) - 'a'] = i;
            }else{
                record[s.charAt(i) - 'a'] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i= 0;i < 26;i++){
            //if(record[i] == 1) return i;
            if(record[i] == Integer.MAX_VALUE) continue;
            min = Math.min(min,record[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    //better 利用字符'a' - 'z'有序的特点进行比较
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;

        int minIndex = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) != -1 && (s.indexOf(c) == s.lastIndexOf(c))) {
                minIndex = Math.min(minIndex, s.indexOf(c));
            }
        }

        return minIndex == s.length() ? -1 : minIndex;
    }
    public static void main(String[] args) {

    }
}
