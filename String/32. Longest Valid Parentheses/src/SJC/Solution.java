package SJC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by SJC on 2018/1/6.
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 */
public class Solution {
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) return 0;
        if(s.indexOf('(') == -1 || s.indexOf(')') == -1) return 0;
        int max = 0;
        int res = 0;
        int left = 0;
        int right = 0;
        int pre = 0;
        int ff = 0;
        List<Integer> index = new ArrayList<>();
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == '('){
            i --;
        }
        if(i == -1) return 0;
        for (int j = i;j >= 0;j--){
            if(s.charAt(j) == ')'){
                right ++;
            }else {
                if(right > 0){
                    right --;
                }else {
                    index.add(j + 1);
                    while (j >=0 && s.charAt(j) == '('){
                        j-- ;
                        ff = 1;
                    }
                    if(ff == 1) j++;
                    ff = 0;
                }
            }
        }
        if(index.size() == 0) return 2 * countNum(s,0,s.length() - 1);
        for (int j = 0;j < index.size();j++) {
            System.out.println(index.get(j));
        }
        res = countNum(s,index.get(0),s.length() -1);
        System.out.println("res1 " + res);
        for(int j = 1 ;j < index.size();j++){
            res = Math.max(countNum(s,index.get(j),index.get(j - 1)),res);
        }
        res = Math.max(countNum(s,0,index.get(index.size() - 1)),res);
        return res * 2;
    }
    public static int countNum(String s,int left,int right){
        if(left >= right) return 0;
        int ans = 0;
        int L = 0;
        int max = 0;
        for(int i = left;i <= right;i++){
            if(s.charAt(i) == '('){
                L++;
            }else {
                if(L == 0){
                    max = Math.max(max,ans);
                    ans = 0;
                }
                if(L > 0){
                    L--;
                    ans++;
                }

            }
        }
        return Math.max(ans,max);
    }
    //better
    public int longestValidParentheses3(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
    //better solution
    public int longestValidParentheses2(String s) {
        if (s.length() == 0) return 0;
        int[] stack = new int[s.length()+1];
        stack[0] = -1;
        int top = 1;
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (arr[i] == '(') {
                stack[top] = i;
                ++top;
            }
            else{
                top--;
                if (top == 0) {
                    stack[top] = i;
                    ++top;
                }
                else {
                    ans = Math.max(ans, i - stack[top-1]);
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));;
    }
}
