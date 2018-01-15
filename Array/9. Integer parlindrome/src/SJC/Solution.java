package SJC;

/**
 * Created by SJC on 2018/1/8.
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x >=0 && x <= 9) return true;
        if(x % 10 == 0) return false;
        int pow = 10;
        while (x >= pow){
            if(x / pow <= 9) break;
            pow = pow * 10;
        };
        int left = pow;
        int right = 1;
        while (left > right){
            if(x / left % 10 != x / right % 10){
                return false;
            }
            left /= 10;
            right *= 10;
        }
        return true;
    }//better
    public boolean isPalindrome2(int x) {
        // if(x==Integer.MIN_VALUE) return false;
        if(x<0) return false; //isPalindrome(-x);
        if(x<10) return true;

        int tens = 1;
        int tmp = x;
        while(tmp/10 > 0){
            tens *= 10;
            tmp = tmp/10;
        }

        while(tens >= 10){
            if(x/tens != x % 10) return false;
            x = x % tens / 10;
            tens /= 100;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
