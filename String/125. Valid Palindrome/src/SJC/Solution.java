package SJC;

/**
 * Created by SJC on 2018/1/7.
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        int head = 0,tail = s.length() - 1;
        while (head <= tail){
            if(!Character.isLetterOrDigit(s.charAt(head))) head++;
            else if(!Character.isLetterOrDigit(s.charAt(tail))) tail--;
            else {
                if(!(Character.toLowerCase(s.charAt(head)) == Character.toLowerCase(s.charAt(tail)))){
                    return false;
                }
                head ++;
                tail --;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(isPalindrome(s));
    }
}
