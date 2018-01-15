package MC;

import java.util.Arrays;

/**
 * Created by SJC on 2017/12/11.
 */
public class quickSort {
    public static int partion(int a[],int p,int q){        //以a[q]为划分元素
        int x = a[q];
        int j = p - 1;
        for(int i = p;i < q;i++) {
            if (a[i] <= x) {
                j++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[q] = a[j+1];
        a[j+1] = x;
        return j+1;
    }
    public static void quickSort(int []a,int l,int r){
        if(l<r){
            int q = partion(a,l,r);
            quickSort(a,l,q-1);
            quickSort(a,q+1,r);
        }

    }
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a==b);
        int [] aa = {1,4,3,20,24};
        System.out.println(partion(aa,0,aa.length-1));
        System.out.println(Arrays.toString(aa));
        quickSort(aa,0,4);
        for(int i = 0; i < aa.length;i++){
            System.out.print(aa[i]+" ");
        }
    }
}
