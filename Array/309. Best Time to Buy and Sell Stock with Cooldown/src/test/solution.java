package test;

/**
 * Created by SJC on 2017/11/1.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class solution {
    public  static int maxProfit(int[] prices) {
        if(prices.length<=1) {
            return 0;
        }
        int [] buy = new int[prices.length];                //当天持有股票状态下获得的最大利润
        int [] sell= new int[prices.length];                //当天无股票状态下获得最大利润
        buy[0] = -prices[0];
        sell[0] =0;
        buy[1]=Math.max(-prices[0],-prices[1]);
        sell[1]=Math.max(0,prices[1]-prices[0]);
        for(int i=2;i<prices.length;i++){
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }
    public static void main(String[] args) {
        int [] prices ={1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
