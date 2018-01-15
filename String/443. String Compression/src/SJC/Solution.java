package SJC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by SJC on 2018/1/5.
 * Given an array of characters, compress it in-place.

 The length after compression must always be smaller than or equal to the original array.

 Every element of the array should be a character (not int) of length 1.

 After you are done modifying the input array in-place, return the new length of the array.
 */
public class Solution {
    public static int compress(char[] chars) {
        if(chars.length == 0) return 0;
        if(chars.length == 1) return 1;
        int len = chars.length;
        int res = 0;
        ArrayList<Character> arr = new ArrayList<>();
        int preSum = 1;
        char preChar = chars[0];
        for(int i = 1;i < len;i++){
            if(chars[i] == chars[i - 1]){
                preSum++;
            }else {
                arr.add(preChar);
                if(preSum == 1){
                    res += 1;
                }else {
                    String s = preSum+"";
                    for(int xx = 0;xx < s.length();xx++){
                        arr.add(s.charAt(xx));
                    }
                    res += 1 + s.length();
                }
                preSum = 1;
                preChar = chars[i];
            }
        }
        String s = preSum+"";
        arr.add(preChar);
        if(preSum > 1){
            for(int xx = 0;xx < s.length();xx++){
                arr.add(s.charAt(xx));
            }
            res += 1 + s.length();
        }else {
            res += 1;
        }

        for(int i = 0; i < arr.size();i++){
            chars[i] = arr.get(i);
        }
        return res;
    }
    public int compress2(char[] chars) {
        int indexAns = 0;
        int index = 0;

        while(index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1) {
                for(char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
    public static void main(String[] args) {
        char[] Char = {'a','b','c'};
        System.out.println(compress(Char));
    }
}
