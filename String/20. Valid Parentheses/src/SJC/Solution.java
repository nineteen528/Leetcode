package SJC;

import java.util.Stack;

/**
 * Created by SJC on 2018/1/10.
 */
public class Solution {
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()) return false;
                else {
                    if(s.charAt(i) == ')'){
                        if(stack.pop() != '(') return false;
                    }
                    if(s.charAt(i) == '}'){
                        if(stack.pop() != '{')return false;
                    }
                    if(s.charAt(i) == ']') {
                        if(stack.pop() != '[') return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println('('-')');
        System.out.println('}' - '{');
        System.out.println(']' - '[');
    }
}
