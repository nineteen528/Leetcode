package test;

/**
 * Created by SJC on 2017/10/31.Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 */
//local[i][j]第i天完成j次交易获得的最大值，并且在第i天完成第j次交易
//global[i][j]第i天完成j次交易获得的最大值，即最终结果
public class solution {
    public static int maxProfit(int k, int[] prices) {
        if(k<=0) return 0;
        if(k>=prices.length/2){
            int res=0;
            for(int i=1;i<prices.length;i++){
                res+=Math.max(prices[i]-prices[i-1],0);
            }
            return res;
        }
        int [][] local =  new int [prices.length][k+1];
        int [][] global = new int [prices.length][k+1];
        local[0][0] = 0;
        global[0][0]=0;
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k&&j<=i;j++){
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(0,prices[i]-prices[i-1]),local[i-1][j]+prices[i]-prices[i-1]);
                global[i][j]=Math.max(global[i-1][j],local[i][j]);
            }
        }
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=k;j++){
                System.out.print(global[i][j]+ "    ");
            }
            System.out.println();
        }
        return global[prices.length-1][k];
    }

    public static void main(String[] args) {
        int []prices ={7, 1, 5, 3, 6, 4};
        int k=2;
        System.out.println(maxProfit(k,prices));
    }
}


    /*
    public int maxProfit(int k, int[] prices) {
        if (prices == null) return -1;
        int n = prices.length;
        if (n == 0 || k <= 0) return 0;
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }
        //state machine; buy[i]/sell[i] : the maximum profit when buy/sell i-times;
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }
        sell[0] = 0;
        // iterate thought the prices array
        for (int j = 0; j < n; j++) {
            int price = prices[j];
            if (j == 0 || price < prices[j - 1])
                // update the whole buy array
                for (int i = 1; i <= k; i++) {
                    if (buy[i] < sell[i - 1] - price) buy[i] = sell[i - 1] - price;
                }
            if (j == 0 || price > prices[j - 1])
                // update the whole sell array
                for (int i = 1; i <= k; i++) {
                    if (sell[i] < buy[i] + price) sell[i] = buy[i] + price;
                }
        }
        int res = 0;
        for (int a : sell) res = Math.max(res, a);
        return res;
    }
    */
