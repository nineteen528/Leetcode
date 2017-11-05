package test;

import org.omg.CORBA.MARSHAL;

/**
 * Created by SJC on 2017/11/1.
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
    public static int maxProfit(int[] prices, int fee) {
        if(prices.length<=1) return 0;
        int [] buy = new int [prices.length];               //当前持股状态下最大利润
        int [] sell = new int[prices.length];               //当前为持股状态下最大利润
        buy[0]=-prices[0];
        buy[1]=Math.max(-prices[0],-prices[1]);
        sell[0]=0;
        sell[1]=Math.max(0,prices[1]-prices[0]-fee);
        int Buy=Math.max(-prices[0],-prices[1]);
        int Sell= Math.max(0,prices[1]-prices[0]-fee);
        for(int i=2;i<prices.length;i++){
           // buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
            //sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
           Buy = Math.max(Buy,Sell-prices[i]);
           Sell = Math.max(Sell,Buy+prices[i]-fee);

        }
        ///return sell[prices.length-1];
        return Sell;
    }
    public static void main(String[] args) {
        int [] prices ={1, 3, 2, 8, 4, 9};
        int fee=2;
        System.out.println(maxProfit(prices,fee));
    }
}

/*  较优解
    public int maxProfit(int[] prices, int fee) {
        int pre_0 = 0, pre_1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int cur_0 = Math.max(pre_0, pre_1 + price);
            int cur_1 = Math.max(pre_1, pre_0 - price - fee);

            pre_0 = cur_0;
            pre_1 = cur_1;
        }

        return pre_0;
    }*/
