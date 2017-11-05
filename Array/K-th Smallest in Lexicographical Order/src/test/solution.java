package test;

import org.omg.CORBA.MARSHAL;

/**
 * Created by SJC on 2017/10/25.
 Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

 Note: 1 ≤ k ≤ n ≤ 109.

 Example:

 Input:
 n: 13   k: 2

 Output:
 10

 Explanation:
 The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

 */
public class solution {
//    public static int findKthNumber(int n, int k){
//        int num[]=new int [9];
//        int res=0;
//        int level=0;
//        int fir_num=0;
//        int t=1;
//        while (t<n){
//            t=t*10;
//            level++;
//        }
//        if(t>n){
//            fir_num = n/(int)Math.pow(10,level-1);
//            for(int i=0;i<fir_num-1;i++){
//                num[i]=0;
//                int tt=0;
//                while(tt<level) {
//                    num[i] += (int) Math.pow(10, tt);
//                    tt++;
//                }
//            }
//            for(int i=fir_num-1;i<=8;i++){
//                num[i]=0;
//                int tt=0;
//                while(tt<level-1){
//                    num[i]+=(int) Math.pow(10, tt);
//                    tt++;
//                }
//            }
//            num[fir_num-1]=num[fir_num-1]+n-(int)Math.pow(10,level-1)+1;
//        }else{
//            fir_num=1;
//            int tt=0;
//            for(int i=0;i<=8;i++){
//                num[i]=0;
//                tt=0;
//                while(tt<level){
//                    num[i]+=(int) Math.pow(10, tt);
//                    tt++;
//                }
//            }
//            num[0]++;
//        }
//        int temp=k;
//
//        for(int i=0;i<=8;i++){
//            temp-=num[i];
//            if(temp<=0){
//                res = i;    //求出位于第几个数组项
//                break;
//            }
//        }
//        if(temp==0){
//            return (res+2)*(int)Math.pow(10,level-1)-1;    //k正好被减完，就等于该数组项最后一个值
//        }else{
//            int rank=k;                                     //否则
//            for(int i=0;i<res;i++){
//                rank-=num[i];                               //k在num[rank]中的排名
//            }
//            if(res!=0){
//                //如果不在num的第一项
//            }else{     //如果在
//                if(fir_num==1){  //如果n是10的次方
//                    if(rank<=level+1){  //如果是1，10，100.。。。
//                        return (int)Math.pow(10,rank-1);
//                    }else{
//
//                    }
//                }
//            }
//        }
//
//
//
//        return res;
//    }
    public static int findKthNumber(int n, int k){
        int curr=1;
        k=k-1;
        while (k>0){
            int steps=calsteps(n,curr,curr+1);
            if(steps<=k){
                curr++;
                k-=steps;
            }else {
                curr*=10;
                k--;
            }
        }
        return curr;
    }
    public static int calsteps(int n,long n1,long n2){
        int steps =0;
        while (n1<=n){
            steps+=Math.min(n+1,n2)-n1;
            n1*=10;
            n2*=10;
        }
        return steps;
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber(2,2));
    }
}
