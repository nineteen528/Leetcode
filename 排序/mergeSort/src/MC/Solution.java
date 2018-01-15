package MC;

import java.util.Arrays;

/**
 * Created by SJC on 2017/12/16.
 * 二路归并
 */
public class Solution {
    public static void mergeSort(int []a,int l,int r){
        if(l == r){
            return;
        }else {
            int middle = (l + r) / 2;
            mergeSort(a,l,middle);
            mergeSort(a,middle+1,r);
            merge(a,l,middle,r);
        }
    }
    public static void merge(int [] a,int l,int middle,int r){
        int []ans = new int [r - l +1];
        int i = l,j = middle+1,count = 0;
        while (i <= middle && j <= r){
            if(a[i] <= a[j]){
                ans[count++] = a[i];
                i++;
            }else {
                ans[count++] = a[j];
                j++;
            }
        }
        while(i <= middle){
            ans[count++] = a[i];
            i++;
        }
        while (j <= r){
            ans[count++] = a[j];
            j++;
        }
       for( i = l;i <= r ;i++){
           a[i] = ans[i-l];
       }
    }
    public static void main(String[] args) {
        int [] a ={26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
