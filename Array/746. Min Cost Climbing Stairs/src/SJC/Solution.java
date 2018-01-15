package SJC;

import org.omg.CORBA.MARSHAL;

/**
 * Created by SJC on 2017/12/21.
 */
public class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        //return minCost(cost,0,cost.length-1);
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        int[] c = new int[cost.length];
        c[0] = cost[0];
        c[1] = cost[1];
        for(int i = 2 ;i < cost.length;i++){
            c[i] = Math.min(c[i-1],c[i-2]) + cost[i];
        }
        return Math.min(c[c.length - 2],c[c.length-1]);
    }
    public static int minCost(int[] cost,int low ,int high){
        if(high - low == 1){
            return Math.min(cost[low],cost[high]);
        }
        if(low == high) return 0;
        return Math.min(cost[low] + minCost(cost,low+1,high),cost[low+1] + minCost(cost,low + 2,high));
    }
    public static void main(String[] args) {
        int[] a = new int[10];
//        a[0] = 1;
//        a[1] = 100;
//        a[2] = 1;
//        a[3] = 1;
//        a[4] = 1;
//        a[5] = 100;
//        a[6] = 1;
//        a[7] = 1;
//        a[8] = 100;
//        a[9] = 1;
        a[0] = 10;
        a[1] = 15;
        a[2] = 20;
        System.out.println(minCostClimbingStairs(a));
    }
}
