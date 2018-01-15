package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by SJC on 2017/12/4.
 */
public class solution {
    public static void main(String[] args) {
        int [] a = {2,8,7,4,1,9,3,14,16,10};
        buildHeap(a);
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void buildHeap(int [] a){
        int len = a.length;
        for(int i = (len-1)/2;i >= 0;i-- ) {
            maxHeapify(a, i);
        }
    }
    public static void maxHeapify(int [] a,int i){
        int L = i*2+1;
        int R = L+1;
        int largest = i;
        if(L < a.length && a[largest] < a[L]){
            largest = L;
        }
        if (R < a.length && a[largest] < a[R]) {
            largest = R;
        }
        if(i != largest){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a,largest);
        }
    }
    public static void heapSort(int a[]){
        buildHeap(a);
        int [] temp = new int[a.length];
        for(int j = 0;j < temp.length;j++){
            temp[j] = a[j];
        }
        for(int i = 0;i < a.length;i++){
            a[a.length-1-i] = temp[0];
            //int t = temp[0];
            temp[0] = temp[temp.length-1-i];
            temp[temp.length-1-i] = Integer.MIN_VALUE;
            maxHeapify(temp,0);
        }
    }
}
