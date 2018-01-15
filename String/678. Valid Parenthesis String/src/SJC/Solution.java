package SJC;

import java.util.Map;

/**
 * Created by SJC on 2018/1/2.
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 An empty string is also valid.
 Example 1:
 Input: "()"
 Output: True
 */
public class Solution {
    public static boolean checkValidString(String s) {
        if(s == null) return false;
        if(s.length() == 1){
            if(s.equals("*"))return true;
            else return false;
        }
        int len1 = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < len1;i++){
            if(s.charAt(i) != ')'){
                sb.append(s.charAt(i));
            }else {
                int index = sb.lastIndexOf("(");
                if(index != -1){
                    sb.deleteCharAt(index);
                }else {
                    sb.append(')');
                }
            }
        }
        System.out.println(sb);
        int len2 = sb.length();

        int leftIndex = -1;
        int leftCount = 0;
        int rightCount = 0;
        int starCount = 0;
        for (int i = 0; i < len2;i++){
            if(sb.charAt(i) == '('){
                leftCount++;
                //leftIndex = i;
            }else if(sb.charAt(i) == '*'){
                starCount++;
            }else {
                rightCount++;
                if(rightCount > leftCount + starCount){
                    return false;
                }
            }
        }
//        int backCount = 0;
//        while (leftIndex >= 0 && sb.charAt(leftIndex) == '('){
//            backCount++;
//            leftIndex--;
//        }
//        if(backCount > len2 - (leftIndex + backCount + 1)) return false;
        int lCount = 0;
        int rCount = 0;
        for(int i = len2 - 1;i >= 0;i--){
            if(sb.charAt(i) == '('){
                lCount++;
                if(lCount > rCount) return false;
            }
            else {
                rCount++;
            }
        }
        if(Math.abs(leftCount - rightCount) <= starCount){
            return true;
        }
        return false;
    }
    //better
    public boolean checkValidString2(String s) {
        int low = 0;                            //只匹配最多low个')"，剩下的交给high处理
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
    public static void main(String[] args) {
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        String s1= "()(()(*(())()*)(*)))()))*)((()(*(((()())()))()()*)((*)))()))(*)(()()(((()*()()((()))((*((*)()";
        System.out.println(checkValidString("(*))"));

        //((*)(*))((*
        //**((*
    }
}
