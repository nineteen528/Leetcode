package SJC;

/**
 * Created by SJC on 2018/1/23.
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class Solution {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null && s2 ==null) return false;
        if(s1 == null) return s2.equals(s3);
        if(s2 == null) return s1.equals(s1);
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length() +1 ][s2.length() + 1];
        for(int i = 1;i < s1.length() + 1;i++){
            if(dp[i - 1][0] == i - 1 && s1.charAt(i - 1) == s3.charAt(i - 1)){
                dp[i][0] = i;
            }
        }
        for(int j = 1;j < s2.length() + 1;j++){
            if(dp[0][j - 1] == j - 1 && s2.charAt(j - 1) == s3.charAt(j -1)){
                dp[0][j] = j;
            }
        }
        for(int i = 1;i < s1.length() + 1;i++){
            for(int j = 1;j < s2.length() + 1;j++){
                if(dp[i][j - 1] == i + j - 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1) ||
                        dp[i - 1][j] == i + j - 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = i + j;
                }
            }
        }
        return dp[s1.length()][s2.length()] == s1.length() + s2.length() ? true : false;
    }
//    private static Set<Integer> visited; // The combination of i1, i2 has been visited and return false
    // 递归
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        if(s3.length() != s1.length() + s2.length())
//            return false;
//        visited = new HashSet<Integer>();
//        return isInterleave(s1, 0, s2, 0, s3, 0);
//    }
//
//    private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3)
//    {
//        int hash = i1 * s3.length() + i2;
//        if(visited.contains(hash))
//            return false;
//
//        if(i1 == s1.length())
//            return s2.substring(i2).equals(s3.substring(i3));
//        if(i2 == s2.length())
//            return s1.substring(i1).equals(s3.substring(i3));
//
//        if(s3.charAt(i3) == s1.charAt(i1) && isInterleave(s1, i1+1, s2, i2, s3, i3+1) ||
//                s3.charAt(i3) == s2.charAt(i2) && isInterleave(s1, i1, s2, i2+1, s3, i3+1))
//            return true;
//
//        visited.add(hash);
//        return false;
//    }
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1,s2,s3));
    }
}
