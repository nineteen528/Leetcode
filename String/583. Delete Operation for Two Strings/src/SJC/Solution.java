package SJC;

import javax.sound.midi.Soundbank;
import java.util.Map;

/**
 * Created by SJC on 2018/1/2.

 Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

 Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class Solution {
    public static int minDistance(String word1, String word2) {
        //char[] ss1 = word1.toCharArray(), ss2 = word2.toCharArray();  转成数组取元素速度会快一点
        if(word1 == null || word1 == "") return word2.length();
        if(word2 == null || word2 == "") return word1.length();
        int len1 =word1.length(),len2 = word2.length();
        int[][] s = new int[len1 + 1][len2 + 1];
        for(int i = 0;i < len1;i++){
            for(int j = 0;j < len2;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    s[i + 1][j + 1] = s[i][j] + 1;
                }else {
                    s[i + 1][j + 1] = Math.max(s[i][j + 1],s[i + 1][j]);
                }
            }
        }
        return len1 + len2 - s[len1][len2] * 2;
    }
    //better 空间复杂度更低 O(n)
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            int pre = 0;                                    //用来记录上一轮的dp值
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = pre+1;
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                pre = tmp;
            }
        }
        return m+n-2*dp[n];
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minDistance(s1,s2));
    }
}
