package SJC;

/**
 * Created by SJC on 2017/12/27.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";
        for (int i = 0; i < len;i++){
            String ss =maxPalindrome(s,i,i);
            String sss = maxPalindrome(s,i,i+1);
            if(ss.length() > ans.length()){
                ans = ss;
            }
            if(sss.length() > ans.length()){
                ans = sss;
            }
        }
        return ans;
    }
    public static String maxPalindrome(String s,int left,int right){
        int len = s.length();
        //String ans = "";
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
            //ans = s.substring(left,right+1);
            left--;
            right++;
        }
        if(left <0 ) left = -1;
        if(right >=len ) right = len;

        return s.substring(left + 1,right);
    }
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(longestPalindrome(s));
    }
}
//better solution
//class Solution {
//    char[] ss;
//    int left=0, max=1;
//    public String longestPalindrome(String s) {
//        ss=s.toCharArray();
//        if(ss.length<1) return "";
//        for(int i=0; i<ss.length; i++){
//            i=update(i);
//        }
//        return s.substring(left, left+max);
//    }
//    private int update(int index){
//        int ll=index, rr=index;
//        while(rr+1<ss.length && ss[rr]==ss[rr+1]){
//            rr++;
//        }
//        int temp=rr;
//        while(rr+1<ss.length && ll-1>=0 && ss[rr+1]==ss[ll-1]){
//            rr++;
//            ll--;
//        }
//        if(rr-ll+1>max){
//            max=rr-ll+1;
//            left=ll;
//        }
//        return temp;
//    }
//}