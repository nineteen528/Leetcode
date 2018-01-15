package sjc;

import java.util.*;

/**
 * Created by SJC on 2017/12/12.
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

 If there is no answer, return the empty string.
 Example 1:
 Input:
 words = ["w","wo","wor","worl", "world"]
 Output: "world"
 Explanation:
 The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 */
public class solution {
    public static String longestWord(String[] words) {
        String res = "";
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        for(String word: words ){
            if(word.length() == 1 || set.contains(word.substring(0,word.length()-1))){
                res = res.length() >= word.length() ? res : word;
                set.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String [] a = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(a));
    }
}
