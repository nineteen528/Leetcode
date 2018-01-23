package SJC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJC on 2018/1/22.
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.


 */
public class Solution {
    public static int numDecodings(String s) {
        if(s == null) return 0;
        if (s.length() == 0)
            return 0;
        int[] t = new int[s.length() + 1];
        t[0] = 1;

        if (s.charAt(0) != '0') t[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (helper(s.substring(i - 1, i))) {
                t[i] += t[i - 1];
            }

            if (helper(s.substring(i - 2, i))) {
                t[i] += t[i - 2];
            }
        }
        return t[s.length()];
    }
    public static boolean helper(String s){
        if(s.charAt(0)=='0')
            return false;
        int value = Integer.parseInt(s);
        return value>=1&&value<=26;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1234");
        sb.toString();
        System.out.println(numDecodings(sb.toString()));
        List<Integer> list = new ArrayList<>();
    }
}
