package test;

/**
 * Created by SJC on 2017/11/19.
 */
public class solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        double res = 0 ;
        int low1 = 0;
        int high1 = nums1.length-1;
        int low2 = 0;
        int high2 = nums2.length;
        int middle1 = (low1 + high1)/2;
        int middle2 = (low2 + high2)/2;
        while (low1<high1 && low2<high2){
            middle1 = (low1 + high1)/2;
            middle2 = (low2 + high2)/2;
            if(nums1[middle1]<nums2[middle2]){
                low1 = middle1 + 1;
                high2 = middle2 -1;
            }else if(nums1[middle1] == nums2[middle2]){

            }else{
                low2 = middle2 + 1;
                high1 = middle1 -1;
            }

        }
        return res;
    }
    public static void main(String[] args) {

    }
}
