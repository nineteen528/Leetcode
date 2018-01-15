package SJc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJC on 2018/1/7.
 *
 */
public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() > 12 || s.length() < 4) return list;
        List<Integer> first = new ArrayList();
        List<Integer> second = new ArrayList<>();
        for (int i = 1;i <= 3;i++){
            if(i == 3 && Integer.parseInt(s.substring(0,3)) > 255) break;
            for(int j = 1;j <= 3 && i + j <= s.length() - 2;j++){
                if(j == 3 && Integer.parseInt(s.substring(i,i + j)) >255) continue;
                if(s.substring(0,i).charAt(0 )== '0' && i > 1 || s.substring(i,i + j).charAt(0) == '0' && j > 1) continue;
                first.add(i - 1);
                first.add(i + j - 1);
            }
        }
        for (int i = 1 ;i < first.size();i+=2){
            System.out.print(first.get(i - 1));
            System.out.print("  ");
            System.out.print("  " + first.get(i));
            System.out.println("  ");

        }
        String ss = new StringBuilder(s).reverse().toString();
        for (int i = 1;i <= 3;i++){
            if(i == 3 && Integer.parseInt(new StringBuilder(ss.substring(0,3)).reverse().toString()) > 255) break;
            for(int j = 1;j <= 3 && i + j <= ss.length() - 2;j++){
                if(j == 3 && Integer.parseInt(new StringBuilder(ss.substring(i,i + j)).reverse().toString()) > 255) continue;
                if(s.substring(ss.length() - i,ss.length()).charAt(0) == '0' && ss.length() - i < ss.length() - 1
                        || s.substring(ss.length() - i - j,ss.length() - i + 1).charAt(0) == '0' && j + 1 > 2) continue;
                second.add(ss.length() - 1 -(i - 1));
                second.add(ss.length() - 1 - (i + j -1));
            }
        }
        System.out.println();
        for (int i = 1 ;i < second.size();i+=2){
            System.out.print(second.get(i - 1));
            System.out.print("  ");
            System.out.print("  " + second.get(i));
            System.out.println("  ");

        }
        for(int i = 1;i < first.size();i+=2){
            for(int j = 1;j < second.size();j+=2){
                if(first.get(i) + 1 == second.get(j)){
                    list.add(s.substring(0,first.get(i - 1) + 1) + "." + s.substring(first.get(i - 1) + 1,first.get(i) + 1) +
                            "." + s.substring(second.get(j),second.get(j - 1)) + "." + s.substring(second.get(j - 1),s.length()));
                }
            }
        }
        return list;
    }
    //better
    public List<String> restoreIpAddresses22(String s) {
        List<String> ret = new ArrayList<>();
        helper(ret,s,0,new int[4], 0);
        return ret;
    }
    public void helper(List<String> ret, String s, int pos, int[] curr, int ind){
        if(ind==4 && pos==s.length()){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<4;i++){
                if(sb.length()>0) sb.append('.');
                sb.append(curr[i]);
            }
            ret.add(sb.toString());
        }else if(ind<4 && pos<s.length()){
            int n = 0;
            for(int i=pos;i<s.length() && i<pos+3;i++){
                n*=10;
                n+=(s.charAt(i)-'0');
                if(n>255) return ;
                curr[ind] = n;
                helper(ret,s,i+1,curr,ind+1);
                if(n==0) return;
            }
            curr[ind] = 0;
        }
    }

    public static void main(String[] args) {
        String sb = "010010";//25525511135
        List<String> l = restoreIpAddresses(sb);
        for(int i = 0; i < l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
