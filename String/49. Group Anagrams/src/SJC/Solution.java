package SJC;

import java.util.*;

/**
 * Created by SJC on 2018/1/14.
 */
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            String m = sortWord(s);
            if(!map.containsKey(m)){
                List<String> str = new ArrayList<>();
                str.add(s);
                map.put(m,str);
            }else {
                List<String> str = map.get(m);
                str.add(s);
                map.put(m,str);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Iterator<Map.Entry<String,List<String >>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, List<String >> entry = entries.next();
            ans.add(entry.getValue());
        }
        return ans;
    }
    private static String sortWord(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> l = groupAnagrams(strs);
        for(List<String> a : l){
            System.out.println(a.toString());
        }
    }
}
