package suda;

/**
 * Created by SJC on 2017/10/28.
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

 You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

 Return the maximum profit you can make.

 Example 1:
 Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 Output: 8
 Explanation: The maximum profit can be achieved by:
 Buying at prices[0] = 1
 Selling at prices[3] = 8
 Buying at prices[4] = 4
 Selling at prices[5] = 9
 The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class solution {
    /*
    //better solution
    public static int maxProfit(int [] prices){
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] > min){
                max = Math.max(max, prices[i] - min);
            }else{
                min = prices[i];
            }
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
    */
    public static  int maxProfit(int[] prices){
        int res=0;
        int curr=0;
        for(int i=1;i<prices.length;i++){
            curr = Math.max(0,curr+=prices[i]-prices[i-1]);
            res = Math.max(curr,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] a ={1,2,6,4,5};
        System.out.println(maxProfit(a));
    }
}
