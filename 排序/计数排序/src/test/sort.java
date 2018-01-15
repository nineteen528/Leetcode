package test;

import java.util.Arrays;

/**
 * Created by SJC on 2017/12/21.
 */
public class sort {
    public static int[] countingSort(int[] a){          //计数排序
        int len = a.length;
        int k = 0;
        for(int i = 0;i < a.length;i++){
            if(a[i] > k){
                k = a[i];
            }
        }
        k++;
        int[] C = new int[k];                           //保持原数组中    数字出现的个数
        int[] B = new int[len];                         //用来记录排序后新数组中
        for (int i = 0;i < k;i++){
            C[i] = 0;
        }
        for (int i = 0;i < len;i++){
            C[a[i]] = C[a[i]] +1;
        }
        for(int i = 1;i < k;i++){
            C[i] = C[i - 1] + C[i];
        }
        for(int i =0;i < k;i++){
            if(C[i] != 0){
                C[i] --  ;
            }
        }
        for (int i = 0;i < len;i++){
            B[C[a[i]]] = a[i];
            C[a[i]] --;
        }
        return B;
    }
    public static void main(String[] args) {
        int[] a = {123,4,6,9,2,5,6};
        System.out.println(Arrays.toString(countingSort(a)));
    }
}
