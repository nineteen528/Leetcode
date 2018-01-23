package SJC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJC on 2018/1/17.
 */
public class Solution {
    public static String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);  // return "d".toString();
    }
    public static void main(String[] args) {
        String a = "vw";
        int n = 2;
        int k = 1;
        System.out.println(getPermutation(n,k));
        List<Integer> digit = new ArrayList<>();
        digit.add(1);
        digit.add(2);
        digit.add(1);
        digit.remove;
        System.out.println(digit.get(0));
    }
}
