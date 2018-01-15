package SJC;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SJC on 2018/1/10.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Solution {
    public static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        List<Character> fStack = new ArrayList<>();
        String str = "";
        helper(n,fStack,str,ans);
        return ans;
    }
    public static void helper(int n,List<Character> stack,String str,List<String> ans){
        List<Character> l1 = new ArrayList<>(stack);
        if(l1.size() > n) return;
        if(n == 0 && l1.size() == 0){
            ans.add(new String(str));
        }
        if(n == 0 && l1.size() != 0) return;
        if(l1.size() == 0){
            l1.add('(');
            String ss = new String(str+"(");
            helper(n ,l1,ss,ans);
        } else if(l1.size() != 0){
            l1.add('(');
            helper(n,l1,new String(str + "("),ans);
            l1.remove(l1.size() - 1);
            l1.remove(l1.size() - 1);
            helper(n - 1,l1,new String(str + ")"),ans);
        }
    }
    // better
    public List<String> generateParenthesis2(int n) {
        List<String> rst = new ArrayList<String>();
        if (n < 1) {
            return rst;
        }
        char[] cur = new char[2 * n];
        helper(n, n, cur, 0, rst);
        return rst;
    }
    private void helper(int left, int right, char[] cur, int index, List<String> rst) {
        if (left + right == 0) {
            rst.add(new String(cur));
            return;
        }
        if (left > 0) {
            cur[index] = '(';
            helper(left - 1, right, cur, index + 1, rst);
        }
        if (right > left) {
            cur[index] = ')';
            helper(left, right - 1, cur, index + 1, rst);
        }
    }

    public static void main(String[] args) {
        List<String> l = generateParenthesis(3);
        for(String s : l)
            System.out.println(s);
    }
}
