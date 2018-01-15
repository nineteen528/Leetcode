package SJC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SJC on 2018/1/7.
 */
public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        Map<Character,String> map = new HashMap<>();
        for(int i = 2;i < 7;i++){
//            System.out.println((char)(i + 48));
            char temp = (char) ('a' + (i - 2) * 3);
//            System.out.println(temp);
//            System.out.println((char)(temp + 1));
            map.put((char)(i + 48),temp + "" + (char)(temp + 1) + "" + (char)(temp + 2));
        }
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ans.add("");
        for(int i= 0;i < digits.length();i++){
            cartesian(ans,map.get(digits.charAt(i)));
        }
        return ans;
    }
    public static void cartesian(List<String> ans,String s){
        int len = ans.size();
        for(int i = 0;i < len;i++){
            for(int j = 0;j < s.length();j++){
                ans.add(ans.get(0) + s.charAt(j));
            }
            ans.remove(0);
        }
    }
    //better soultion
    private String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        char[] curr = new char[digits.length()];
        helper(digits, result, curr, 0);
        return result;
    }

    private void helper(String digits, List<String> result, char[] curr, int level) {
        //base case
        if(level == digits.length()) {
            result.add(new String(curr));
            return;
        }

        //recursion rule
        String currStr = letter[digits.charAt(level) - '0'];
        if(currStr.length() == 0) {
            helper(digits, result, curr, level + 1);
        } else {
            for(int i = 0; i < currStr.length(); i++) {
                char currLetter = currStr.charAt(i);
                curr[level] = currLetter;
                helper(digits, result, curr, level + 1);
            }
        }
    }
    public static void main(String[] args) {
        List<String> list = letterCombinations("232");
        for(String s: list)
            System.out.println(s);
    }
}
