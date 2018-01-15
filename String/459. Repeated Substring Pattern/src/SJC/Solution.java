package SJC;


/**
 * Created by SJC on 2018/1/4.
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 */
public class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() == 1) return false;
        int len = s.length();
        for (int i = 0; i < len / 2;i++){
            String s1 = s.substring(0,i + 1);
            if(len % (i + 1) != 0) continue;
            boolean flag = true;
            for(int j = i + 1;j < len;j += (i + 1 )){
                if(!s.substring(j,j + (i + 1)).equals(s1)){
                    flag = false;
                    break;
                }
            }
            if (flag == true) return true;
        }
        return false;
    }
    public boolean repeatedSubstringPattern2(String str) {
        int len = str.length();
        for(int i=len/2 ; i>=1 ; i--) {
            if(len%i == 0) {
                int m = len/i;
                String subS = str.substring(0,i);
                int j;
                for(j=1;j<m;j++) {
                    if(!subS.equals(str.substring(j*i,i+j*i))) break;
                }
                if(j==m)
                    return true;
            }
        }
        return false;
    }
    //better solution
    /*
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;

        int len = s.length(), mid = len / 2; // half
        if (s.substring(0, mid).equals(s.substring(mid))) return true;

        int one_third = len / 3; // 1/3
        String sub = s.substring(0, one_third);
        if (sub.equals(s.substring(one_third, one_third * 2))
                && sub.equals(s.substring(one_third * 2))) return true;

        if (len % 2 == 1) { // odd number of characters
            char c = s.charAt(0);
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) != c) return false;
            }
            return true;
        }

        return false;
    }
    */
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}
