package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by SJC on 2017/10/29.
 *Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 */
public class solution {
    public static int maxProfit(int[] prices) {
        /* O(n^2) 超时
        int res=0;
        int [] fir = new int[prices.length];
        int [] sec = new int[prices.length];
        int  min= prices[0];
        for(int i=0;i<prices.length;i++) {
            res = 0;
            min = prices[0];
            for (int j = 0; j <= i; j++) {
                if (prices[j] < min) {
                    min = prices[j];
                } else {
                    res = Math.max(res, prices[j] - min);
                }
            }
            fir[i] = res;
        }
        for(int i=0;i<prices.length;i++){
            res=0;
            min=prices[i];
            for(int j=i;j<prices.length;j++){
                if(prices[j]<min){
                    min=prices[j];
                }else{
                    res=Math.max(res,prices[j]-min);
                }
            }
            sec[prices.length-1-i]=res;
        }
        res=0;
        for(int i=0;i<prices.length;i++){
            res=Math.max(res,fir[i]+sec[prices.length-1-i]);
        }
        return res;*/
        if(prices.length<=1) return 0;
        int res=0;
        int A[]=new int [prices.length];
        int B[]=new int [prices.length];
        int min = prices[0];
        A[0]=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            A[i] = Math.max(A[i-1],prices[i]-min);
        }
        int max=prices[prices.length-1];
        B[prices.length-1]=0;
        for(int i= prices.length-2;i>=0;i--){
            if(prices[i]>max){
                max=prices[i];
            }
            B[i]=Math.max(B[i+1],max-prices[i]);
        }
        for(int i=0;i<prices.length;i++){
            res =  Math.max(res,A[i]+B[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int []prices={1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(maxProfit(prices));
    }

//      最优解
//      public int maxProfit(int[] prices) {
//        int bought1 = Integer.MIN_VALUE, bought2 = Integer.MIN_VALUE;
//        int sold1 = 0, sold2=0;
//
//        for(int i : prices){
//            sold2 = Math.max(sold2, bought2 + i);
//            bought2 = Math.max(bought2, sold1 - i);
//            sold1 = Math.max(sold1, bought1 + i);
//            bought1 = Math.max(bought1, -i);
//
//        }
//        return sold2;
//    }
}
