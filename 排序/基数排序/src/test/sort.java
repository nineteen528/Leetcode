package test;

import java.util.Arrays;

/**
 * Created by SJC on 2017/12/21.
 */
public class sort {
    public static void radixSort(int[] a){          //基数排序
        int len = a.length;                                         //从个位开始向前排序
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < len;i++){
            max = Math.max(max,a[i]);
        }
        int k =1;
        int[][] B = new int[10][len];
        int[] C = new int[10];
        while (k < max){                                       //循环次数为数的位数
            for (int i = 0;i < len;i++){
                int d = a[i] / k % 10;
                B[d][C[d]++] = a[i];
            }
            int count = 0;
            for(int i = 0;i < 10;i++){
               for(int j = 0;j < C[i];j++){
                   a[count++] = B[i][j];
               }
            }
            k = k*10;
            B = new int[10][len];
            C = new int[len];
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,34,5,6,10,6598,34,56,7,23};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }
}
