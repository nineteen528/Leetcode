package SJC;

/**
 * Created by SJC on 2018/1/4.
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.
 Example 1:
 Input: "USA"
 Output: True
 Example 2:
 Input: "FlaG"
 Output: False
 */
public class Solution {
    public static  boolean detectCapitalUse(String word) {
        if (word == null || word.equals("")) return false;
        if(word.length() == 1) return true;
        char[] words = word.toCharArray();
        boolean ff = Character.isLowerCase(words[0]);
        boolean flag = Character.isLowerCase(words[1]);
        boolean f1 = true;
        for(int i = 2; i < words.length;i++){
            if(flag != Character.isLowerCase(words[i])){
                f1 = false;
                break;
            }
        }
        if(!f1) return false;
        if(ff && f1 && !flag) return false;
        return true;
    }
    //better
    public boolean detectCapitalUse2(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) < 'a') {
                sum += 1;
            }
        }
        if (sum == word.length()) {
            return true;
        }
        if (sum == 1 && (word.charAt(0) >= 'A' && word.charAt(0) < 'a')) {
            return true;
        }
        if (sum == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "glP";
        System.out.println(detectCapitalUse(s));
    }
}
