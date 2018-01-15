package SJC;

/**
 * Created by SJC on 2017/12/24
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters..
 */
public class Solution {
    public static int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int ans =0;
        for(int i = 0 ;i < len;i++){
            int left = i,right = i;
            while (left >= 0 && right < len){
                if(s.charAt(left) == s.charAt(right)){
                    ans++;
                }else{
                    break;
                }
                left--;
                right++;
            }
        }
        for(int i = 0;i < len - 1;i++){
            int left = i,right = i+1;
            if(s.charAt(i) != s.charAt(i+1)) continue;
            while (left >= 0 && right < len){
                if(s.charAt(left) == s.charAt(right)){
                    ans++;
                    left --;
                    right ++;
                }else {
                    break;
                }
            }
//            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
//                ans ++;
//                left --;
//                right ++;
//            }
        }
        return ans;
    }
    //better
    public int countSubstrings2(String s) {
        if(s==null || s.length()==0) return 0;

        int n=s.length();
        int res=0;
        for(int i=0; i<n; i++){
            res+=helper(s, i, i);
            res+=helper(s, i, i+1);
        }
        return res;
    }

    private int helper(String s, int l, int r){
        int res=0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        String a = "abc";
        System.out.println(countSubstrings(a));
    }
}
