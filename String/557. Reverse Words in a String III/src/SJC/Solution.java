package SJC;

import java.util.Stack;

/**
 * Created by SJC on 2018/1/3.
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class Solution {
    public static String reverseWords(String s) {
        if(s == null) return null;
        if(s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> ss = new Stack<>();
        String ans = "";
        for(int i = s.length() - 1;i >= 0;i--){
            if(s.charAt(i) == ' ') continue;
            while (i >= 0 && s.charAt(i) != ' '){
                sb.append(s.charAt(i--));
            }
            ss.push(sb);
            sb = new StringBuilder();
        }
        while (!ss.isEmpty()){
            ans += ss.pop().toString() + " ";
        }
        return ans.substring(0,ans.length() - 1);
    }
    //better solution
    public String reverseWords2(String s) {
        char[] words=s.toCharArray();
        int i=0;
        while(i<words.length){
            i=skipSpace(words, i);
            int j=findEndOfWord(words,i,words.length);
            reverseWord(words,i,j);
            i=j+1;
        }
        return new String(words);
    }

    int skipSpace(char[] words, int i){
        while(words[i]==' '){
            i++;
        }
        return i;
    }

    int findEndOfWord(char[] words, int i, int len){
        while(i<len&&words[i]!=' '){
            i++;
        }
        return i-1;
    }

    public static void reverseWord(char[] words, int i, int j){
        int p=i;
        int q=j;
        while(p<q){
            char temp=words[p];
            words[p]=words[q];
            words[q]=temp;
            p++;
            q--;
        }
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
