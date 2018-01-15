package SJC;

import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SJC on 2018/1/1.
 */
public class Solution {
    public static int repeatedStringMatch(String A, String B) {
        if(A == null || B == null) return -1;
        if(!contains(A,B)) return -1;
        int len1 = A.length();
        int len2 = B.length();
        String temp = A;
        int num = 0;
        int ans = 0;
        for (int i = 0;i < len1;i++){
            while (A.charAt(i) != B.charAt(0)){
                i++;
                if(i >= len1) return -1;
            }
            int j = i;
            while (A.charAt(j) == B.charAt(num)){
                j++;
                num++;
                if(num == len2){
                    return j % len1 == 0 ? j / len1 : j / len1 + 1 ;
                }
                if(j % len1 == 0){
                    A += temp;
                }
            }
            num = 0;
        }
        return -1;
    }
    public static boolean contains(String A,String B){
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < B.length();i++) set.add(B.charAt(i));
        for(int i = 0;i < A.length();i++){
            set.remove(A.charAt(i));
            if(set.size() == 0) return true;
        }
        return false;
    }
    public static int repeatedStringMatch3(String A, String B) {
        if(A == null || B == null) return -1;
        int len1 = A.length();
        int len2 = B.length();
        int num = 0;
        int ans = 1;
        for (int i = 0;i < len1;i++){
            while (A.charAt(i) != B.charAt(0)){
                i++;
                if(i >= len1) return -1;
            }
            int j = i;
            while (A.charAt(j) == B.charAt(num)){
                if(num == len2 - 1){
                    return ans ;
                }
                j = (j + 1) % len1;
                num++;
                if(j == 0) ans++;
            }
            num = 0;
        }
        return -1;
    }
    //better solution
    public int repeatedStringMatch2(String A, String B) {
        int ans = 1;
        if (B.isEmpty() || A.equals(B)) return ans;

        int n = A.length();
        int m = B.length();
        char firstB = B.charAt(0);
        int i = 0;
        int j = 0;
        boolean found = true;
        // Check if B is in the middle of A or in the second half of A
        while ((i = A.indexOf(firstB, i)) != -1) {
            found = true;
            for (j = 0; j < m && i + j < n; j++) {
                // In the middle?
                if (A.charAt(i + j) != B.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                // Match in the mddle
                if (j == m) return ans;
                    // Match second half of A
                else if (i + j == n) {
                    break;
                }
            }
            i++;
        }
        if (!found) return -1;
        i = 0;
        while (j < m) {
            if (A.charAt(i) != B.charAt(j)) {
                return -1;
            }
            if (i == 0) {
                ans++;
            }
            j++;
            i = (i + 1) % n;
        }
        return ans;
    }
    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        System.out.println(repeatedStringMatch(A,B));
    }
}


