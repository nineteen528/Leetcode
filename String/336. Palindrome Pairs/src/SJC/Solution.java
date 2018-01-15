package SJC;

import com.sun.corba.se.spi.orb.StringPair;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by SJC on 2018/1/3.
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class Solution {
    public static List<List<Integer>> palindromePairs(String[] words) {
//        if (words.length < 2) return null;
//        Map<String,ArrayList<Integer>> map  = new HashMap<>();
//        int len = words.length;
//        for(int i = 0; i < len;i++){
//            ArrayList<Integer> list = map.getOrDefault(map.get(words[i]),new ArrayList<>());
//            list.add(i);
//            map.put(words[i],list);
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i = 0;i < len;i++){
//            String s = palindrome(words[i]);
//            if(map.containsKey(s)){
//                ArrayList<Integer> list = map.get(s);
//                if (s.equals(words[i])){
//                    for(int j = 0;j < list.size();j++){
//                        while (j < list.size() && list.get(j) > i){
//                            List<Integer> temp = new ArrayList<>();
//                            temp.add(i);
//                            temp.add(list.get(j));
//                            res.add(temp);
//                            j++;
//                        }
//                    }
//                }else {
//                    for (int j = 0;j < list.size();j++){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(i);
//                        temp.add(list.get(j));
//                        res.add(temp);
//                    }
//                }
//            }
//        }
//        return res;
        if(words.length < 2) return null;
        List<List<Integer>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0;i < len;i++){
            map.put(words[i],i);
        }
        for (int i= 0 ;i < len;i++){
            for (int j = 0;j <= words[i].length();j++){
                String s1 = words[i].substring(0,j);
                String s2 = words[i].substring(j);
                String str = new StringBuilder(s2).reverse().toString();
                if(palindrome(s1) && map.containsKey(str) && map.get(str) != i){
                    List<Integer> list = new ArrayList<>();
                    list.add(map.get(str));
                    list.add(i);
                    res.add(list);
                }
                str = new StringBuilder(s1).reverse().toString();
                if(palindrome(s2) && map.containsKey(str) && map.get(str) != i && s2.length() != 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(map.get(str));
                    res.add(list);
                }
            }
        }
        return res;
    }
    public static boolean palindrome(String s){
        int left = 0,right = s.length() - 1;
        while (left <= right ){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"bat","tab","cat"};
        List<List<Integer>> list = palindromePairs(words);
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i).get(0) + "  " + list.get(i).get(1));
        }
    }
}
