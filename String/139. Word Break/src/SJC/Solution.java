package SJC;

import java.util.*;

/**
 * Created by SJC on 2018/1/18.
 */
public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        //for(String ss : wordDict) set.add(ss);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            String tmp = queue.poll();
            if(tmp.replace("*","").equals("")) return true;
            for(int i = 0;i < wordDict.size();i++){
                if(tmp.indexOf(wordDict.get(i)) == -1){
                    continue;
                }else {
                    queue.add(tmp.replaceFirst(wordDict.get(i),"*"));
                }
            }
        }
        return false;
    }
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String ss : wordDict) set.add(ss);
        boolean[] flag = new boolean[wordDict.size() +  1];
        flag[0] = true;
        for(int i = 1;i < s.length() + 1;i++){
            for(int j = 0;j < i;j++){
                if(flag[j] && set.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
    public static void main(String[] args) {
        String s = "ccbb";
        List<String> list = new ArrayList<>();
        list.add("cb");
        list.add("bc");
        list.add("c");
        list.add("b");
        System.out.println(wordBreak(s,list));
    }
}
