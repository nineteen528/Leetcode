package SJC;

import java.util.Arrays;

/**
 * Created by SJC on 2018/1/2.
 */
public class Select {
    public static int selectKthMin(int[] a,int left,int right,int k){
        int len = right - left + 1;
        if(len <= 5){
            insertSort(a,left,right);
            return a[k - 1 + left];
        }
        int area = len / 5;
        for (int i = 0; i < area;i++){
            insertSort(a,left + 5 * i,left + 5 * i + 4);
        }
        insertSort(a,left + area * 5,right);
        int[] M = new int[area];
        for (int i = 0;i < area;i++){
            M[i] = a[2 + i * 5];
        }
        int v = selectKthMin(M,0,area - 1,area / 2 + 1);
        System.out.println(v + "V");
        int j = partion(a,left,right,v);
        System.out.println(j + "J");
        if((j - left + 1) == k) return a[left + j];
        else if((j - left + 1) > k){
            System.out.println(k + "   1");
            return selectKthMin(a,left,j - 1,k);
        }
        else{
            System.out.println(k + "   2");
            return selectKthMin(a,j + 1,right,k - (j - left + 1));
        }

    }
    public static void insertSort(int[] a,int l,int r){
        //System.out.println("r: " + r + "l: " + l);
        if(r <= l) return;
        for(int i = l + 1;i <= r;i++){
            int j = i - 1,temp = a[i];
            while (j >= l && temp < a[j]){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }
    public static int partion(int[] a,int left,int right,int target){
        int index = -1;
        System.out.println(left + "dfgdgf" + right + "dsf" + target);
        while (left < right){
            while (a[left] <= target){
                if(a[left] == target){
                    index = left;
                }
                left++;
            }
            while (a[right] > target){
                right--;
            }
            if(left < right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                if(a[left] == target) {
                    index = left;
                }
            }
        }
//        System.out.println(left);
//        System.out.println(right);
//        System.out.println(index);
        int tmp = a[index];
        a[index] = a[right];
        a[right] = tmp;
        return right;
    }
    public static void main(String[] args) {
        int[] a= {0,3,6,2,4,9,10,20,21};
        //insertSort(a,0,a.length-1);
        //partion(a,0,a.length-1,4);
        System.out.println(selectKthMin(a,0,8,4));
        //System.out.println(Arrays.toString(a));
    }
}
