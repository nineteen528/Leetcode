package SJC;

/**
 * Created by SJC on 2018/1/8.
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int j = 1;
        for(int i = 0;i < strs[0].length();i++){
            for(j = 1;j < strs.length;j++){
                if(i == strs[j].length()) return strs[0].substring(0,i);
                if(strs[j].charAt(i) != strs[0].charAt(i)) return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
    public static void main(String[] args) {
        String[] str = {"abxsdf","ad"};
        System.out.println(longestCommonPrefix(str));
    }
}
