package test;

import com.sun.xml.internal.bind.v2.runtime.output.DOMOutput;

import java.util.*;

/**
 * Created by SJC on 2017/11/29.
 */
public class solution {
    //递归解01背包
    public static int Recursive(int []c,int [] w,int i,int max_weight){
        int max_profit =0 ;
        while(i < c.length && w[i] > max_weight){
            i++;
        }
        if( i<c.length){
            max_profit = Math.max( c[i] + Recursive(c,w,i+1,max_weight-w[i]), Recursive(c,w,i+1,max_weight));
            //max_profit = Math.max(max_profit + c[i] + DP(c,w,i+1,max_weight-w[i]),max_profit + DP(c,w,i+1,max_weight));
        }
        return max_profit;
    }
    //动态规划解  不用完全塞满
    public static int DP(int []c ,int [] w,int bound){
        int Len = c.length;
        int s[][] = new int[Len+1][bound+1];
        for(int i = 0;i <= Len;i++){
            for(int j = 0;j < bound+1;j++){
                s[i][j] = 0;
            }
        }
        for(int i = 1 ;i <= Len;i++){
            for(int j = 1;j < bound+1;j++){
                if(j >= w[i-1]){
                    s[i][j] = Math.max(s[i-1][j],s[i-1][j-w[i-1]]+c[i-1]);
                }else {
                    s[i][j] = s[i-1][j];
                }
            }
        }
        return s[Len][bound];
    }
    //动态规划解 优化空间复杂度
    public static int DP_optimization(int []c ,int [] w,int bound){
        int Len = c.length;
        int [] s =new int[bound+1];
        for (int  i = 1;i <=Len;i++){
            for(int j = bound;j >= 0;j--){
                if(j >= w[i-1]){
                    s[j] = Math.max(s[j],s[j-w[i-1]]+c[i-1]);
                }
            }
        }
        return s[bound];
    }
    //贪心算法解0-1分数背包
    public static int Greedy(int [] c,int w[],int bound){
        int profit = 0;
        int Len =c.length;
        Map<Double,Integer> temp = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2 - o1);
            }
        });
        for(int i = 0 ;i < Len;i++){
            temp.put((double)c[i]/w[i],i);
        }
        double [] cc = new double[Len];
        int [] ww =new int[Len];
        int ttt = 0;
        for (Double value : temp.keySet()) {

            System.out.println("Value = " + value);
            cc[ttt] = value;
            ttt++;
        }
        ttt=0;
        for (Integer value : temp.values()) {

            //System.out.println("Value = " + value);
            ww[ttt] = w[value];
            cc[ttt] = c[value];
            System.out.println(ww[ttt]);
            ttt++;;
        }
        int x = 0;
        while (x < Len && bound > 0){
            if(bound >= ww[x] ){
                bound -= ww[x];
                profit += cc[x];
                x++;
            }else {
                profit += bound * (cc[x]/ww[x]);
                break;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int c[] ={60,120,100};
        int [] w = {10,30,20};
        int upbound = 30;
        System.out.println(Recursive(c,w,0,upbound));
        System.out.println(Greedy(c,w,upbound));
        System.out.println(DP(c,w,upbound));
        System.out.println(DP_optimization(c,w,upbound));
        ArrayList<Integer> bb = new ArrayList<>();
        Node a =new Node(bb);
        ArrayList<Integer> cc = a.getA();
        System.out.println(a.a.size());
        System.out.println(cc.size());
        a.setA();
        System.out.println(a.a.size());
        System.out.println(cc.size());
    }
}
