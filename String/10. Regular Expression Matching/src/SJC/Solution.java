package SJC;

import java.util.*;

/**
 * Created by SJC on 2017/12/17.
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        if(s.length() > p.length()) return false;
        Set<Character> a = new HashSet();
        for(int mm = 0;mm < s.length();mm++){
            a.add(s.charAt(mm));
        }
        boolean flag = true;
        for(int mm = 0;mm < p.length();mm++){
            if(a.contains(p.charAt(mm))){
                System.out.println("dfd");
                flag = false;
                break;
            }
        }
        System.out.println(flag);
        if(flag){
            return false;
        }
        int i = 0,j = 0,len1 = s.length();
        int len2 = p.length();
        for(int xx =0;xx < len2-1;xx++){
            if(p.charAt(xx) =='.' && p.charAt(xx+1)=='*'){
                return true;
            }
        }
        int jNum = 0;
        while (i < len1 && jNum <= len2-len1 && j < p.length()){
            if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'){
                i++;
                j++;
            }
            else if(p.charAt(j) == '*'){
                if(p.charAt(j-1) == s.charAt(i)){ //占位置及占几个位置 包括0 ;
                    if(i == s.length()-1) return true;
                    int count = findLength(i,s,p.charAt(j-1));
                    for(int xx = 0;xx <= count;xx++){
                        if(isMatch(s.substring(i + xx ,s.length()),p.substring(j+1,p.length()))){
                            return true;
                        }
                    }
                    return false;
                }else{
                    if((j+1) <= p.length()-1 && p.charAt(j+1) == s.charAt(i)){
                        i++;
                        j+=2;
                    }else{
                        i = 0;
                        jNum++;
                        j = jNum;
                    }
                }
            }else{
                i = 0;
                jNum++;
                j = jNum;
            }
        }
        if(i == len1){
            return true;
        }
        return false;
    }
    public static int findLength(int i,String s,char c){
        int count = 1;
        for(int k = i+1;k< s.length();k++){
            if(s.charAt(k) == c){
                count++;
            }else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String a = "aa";
        String b = "a*";
        Set ac = new HashSet();
        System.out.println(a);
        System.out.println(isMatch(a,b));
    }
    //dp solution
    /*
    public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
     return dp[s.length()][p.length()];
    }
    */
}
