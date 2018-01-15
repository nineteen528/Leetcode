package SJC;

import java.util.*;
/**
 * Created by SJC on 2018/1/11.
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 */
public class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        if(words == null || words.length == 0 || s == null || s.length() == 0) return new ArrayList<>();
        int len1 = s.length();
        int len2 = words.length;
        int len3 = words[0].length();
        if(len1 < len2 * len3) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Map<String,Integer>map = new HashMap<>();
        for(String ss : words){
            map.put(ss,map.getOrDefault(ss,0) + 1);
        }
        for(int i = 0;i <= len1 - len2 * len3;i++){
            if(can(s.substring(i,i + len2 * len3),len3,map)){
                ans.add(i);
            }
        }
        return ans;
    }
    private static boolean can(String s,int k,Map<String,Integer> map){
        Map<String,Integer> m1 = new HashMap<>(map);
        if(s == null) return false;
        for(int i = 0;i <= s.length() - k;i+= k){
            String str = s.substring(i,i + k);
            if(!m1.containsKey(str)){
                return false;
            }else {
                int num = m1.get(str);
                if(num == 1) m1.remove(str);
                else m1.put(str,num - 1);
            }
        }
        if(m1.size() == 0) return true;
        return false;
    }
    //
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> cur = new HashMap<>();
        int curCount = 0;

        for(String ss : words){
            if(map.containsKey(ss)){
                map.put(ss, map.get(ss) + 1);
            }
            else{
                map.put(ss, 1);
            }
        }

        int wordLength = words[0].length();

        for(int j = 0; j < wordLength; j += 1){

            int start = j;

            for(int i = j; i <= s.length() - wordLength; i += wordLength){

                String word = s.substring(i, i + wordLength);

                if(map.containsKey(word)){

                    if(cur.containsKey(word)){
                        cur.put(word, cur.get(word) + 1);
                    }
                    else{
                        cur.put(word, 1);
                    }

                    curCount += 1;

                    while(cur.get(word) > map.get(word)){
                        String oldWord = s.substring(start, start + wordLength);
                        start += wordLength;
                        curCount -= 1;
                        cur.put(oldWord, cur.get(oldWord) - 1);
                    }

                    if(curCount == words.length){
                        output.add(start);
                        String oldWord = s.substring(start, start + wordLength);
                        start += wordLength;
                        curCount -= 1;
                        cur.put(oldWord, cur.get(oldWord) - 1);
                    }
                }
                else{
                    cur.clear();
                    curCount = 0;
                    start = i + wordLength;
                }

            }

            curCount = 0;
            cur.clear();

        }
        return output;
    }
    public static void main(String[] args) {
        String[] words = {"ds","vc"};
        findSubstring("sddsgdsgdsgdsdssgsxcv",words);
    }
}
