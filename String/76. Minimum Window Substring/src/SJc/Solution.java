package SJc;

import java.util.*;

/**
 * Created by SJC on 2018/1/19.
 */
public class Solution {
    public static String minWindow(String s, String t) {
        if(s == null || t ==null) return "";
        Map<Character,List<Integer>> map = new HashMap<>();                         //记录目标string中每个字符的位置
        String ans = "";
        for(int i = 0;i < t.length();i++){
            List tmp = map.getOrDefault(t.charAt(i),new LinkedList<>());
            tmp.add(-2);
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),tmp);
            }
        }
        int min = Integer.MAX_VALUE;
        int count = t.length();
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int head = map.get(s.charAt(i)).remove(0);
                map.get(s.charAt(i)).add(i);
                if(head == -2){
                    count -- ;
                    if(count == 0){
                        int min1 = s.length() + 1;
                        System.out.println(min1);
                        for (List<Integer> value : map.values()) {
                            min1 = Math.min(min1,value.get(0));
                        }
                        System.out.println(min1);
                        System.out.println(min);
                        System.out.println(i);
                        if(min > i - min1){
                            min = i - min1;
                            ans = s.substring(min1,i + 1);
                        }
                        count++;
                        map.get(s.charAt(min1)).set(0,-2);
                    }
                }
            }
        }
        return ans;
    }
    public static String minWindow2(String s, String t) {
        if(s == null || t == null) return "";
        String ans = "";
        int[] record = new int[128];
        for(Character c : t.toCharArray()){
            record[c] ++;
        }
        int start = 0,end = 0,count = t.length(),head = start,distance = Integer.MAX_VALUE;
        for(end = 0; end < s.length();end++){
            if(record[s.charAt(end)] --> 0){
                count --;
            }
            while (count == 0){
                if(end - start < distance){
                    head = start;
                    distance = end - start;
                }
                if(record[s.charAt(start++)] ++ == 0){            //如果record[i] > 0 表示还需要减少元素，元素已经溢出了
                    count++;
                }
            }
        }
        return distance == Integer.MAX_VALUE ? "" : s.substring(head,head + distance + 1);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "AB";
        System.out.println(minWindow2(s,t));
    }
}
