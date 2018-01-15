package SJC;

import java.util.Stack;

/**
 * Created by SJC on 2018/1/4.
 */
public class Solution {
    public static int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
    //better
    public int calculate2(String s) {
        int cur = 0, res = 0, prod = 1;
        char prevOp = '+';
        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : '+';
            if (c == ' ') {
                continue;
            }
            else if (c >= '0' && c <= '9') {
                cur = cur * 10 + (c - '0');
            } else {
                int tmp;
                if (prevOp == '/') {
                    tmp = prod / cur;
                } else {
                    tmp = prod * cur;
                }
                if (c == '+' || c == '-') {
                    res += tmp;
                    prod = c == '+' ? 1 : -1;
                } else {
                    prod = tmp;
                }
                cur = 0;
                prevOp = c;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "3*2*4";
        System.out.println(calculate(s));
    }
}
