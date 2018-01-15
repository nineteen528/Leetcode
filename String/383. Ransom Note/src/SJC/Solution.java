package SJC;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SJC on 2018/1/7.
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 */
public class Solution {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine ==  null) return false;
        if(ransomNote.length() > magazine.length()) return false;
        if(ransomNote.length() == 0) return true;
        Map<Character,Integer> map = new HashMap<>(ransomNote.length() % 2 == 0 ? ransomNote.length() : ransomNote.length() + 1);
        for (int i = 0;i < ransomNote.length();i++){
            map.put(ransomNote.charAt(i),map.getOrDefault(ransomNote.charAt(i),0) + 1);
        }
        for(int i = 0;i < magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))){
                int remain = map.get(magazine.charAt(i));
                if(remain == 1){
                    map.remove(magazine.charAt(i));
                }else {
                    map.put(magazine.charAt(i),remain - 1);
                }
            }
        }
        if(map.size() == 0) return true;
        return false;
    }
    /*
         if(magazine.length() == 0) return ransomNote.length() == 0;
                int[] table = new int[26];
                int n = ransomNote.length();
                for(int i = 0; i < ransomNote.length(); i++){
                    table[ransomNote.charAt(i)-'a']++;
                }
                int count = 0;
                for(int i = 0; i < magazine.length(); i++){
                    char c = magazine.charAt(i);
                    table[c-'a']--;
                    if(table[c-'a'] >= 0) count++;
                    if(count == n) return true;
                }
        return false;
     */
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aab";
        System.out.println(canConstruct(s1,s2));
    }
}
