package SJC;

/**
 * Created by SJC on 2018/1/1.
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.

 Example 1:
 Input: "00110011"
 Output: 6
 Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

 Notice that some of these substrings repeat and are counted the number of times they occur.

 Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 Example 2:
 Input: "10101"
 Output: 4
 Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 */
public class Solution {
    public static int countBinarySubstrings(String s) {
        if (s == null || s.length() <= 1) return 0;
        int sum = 0;
        int len = s.length();
        //int[] a = new int[2];
       // a[s.charAt(0) - '0']++;
        int curr = 1;
        int pre = 0;
        for (int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i - 1)){
               // a[s.charAt(i) - '0']++;
                curr++;
//                if(a[s.charAt(i) - '0'] <= a[1 - (s.charAt(i) - '0')]){
//                    sum++ ;
//                }
                if(curr <= pre){
                    sum++ ;
                }
            }else{
//                a[s.charAt(i) - '0'] = 1;
                pre = curr;
                curr = 1;
                //if(a[s.charAt(i) - '0'] <= a[1 - (s.charAt(i) - '0')]){
                    sum++;
                //}
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings(s));
    }
    //better
    /*
    public static int countBinarySubstrings(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        int zeroCount = 0, oneCount = 0;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == '0') {
                zeroCount = 1;
                while (++i < arr.length && arr[i] == '0' ) {
                    zeroCount++;
                }
            } else {
                oneCount = 1;
                while (++i < arr.length && arr[i] == '1') {
                    oneCount++;
                }
            }
            count += Math.min(zeroCount, oneCount);
        }
        return count;
    }
    */
    /*
    public static int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }
    */
}
