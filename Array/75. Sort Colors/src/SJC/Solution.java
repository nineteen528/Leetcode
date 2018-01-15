package SJC;

import java.util.Arrays;

/**
 * Created by SJC on 2018/1/15.
 */
public class Solution {
    public static void sortColors(int[] nums){
        if(nums == null || nums.length == 0) return;
//        for(int i = 1;i < nums.length;i++){
//            if(nums[i] == 0){
//                int j;
//                for(j = i;j >= 1 && nums[j - 1] != 0 ;j--){
//                    nums[j] = nums[j - 1];
//                }
//                nums[j] = 0;
//             //System.out.println(j);
//            }else if(nums[i] == 1){
//                int j;
//                for(j = i;j >= 1 && nums[j - 1] >= 1 ;j--){
//                    nums[j] = nums[j - 1];
//                }
//                nums[j] = 1;
//            }else {
//                nums[i] = 2;
//            }
//        }
        int left  = 0,right = nums.length;
        for(int i = 0;i < right;i++){
            if(nums[i] == 0){

                nums[i] = nums[left];
                nums[left++] = 0;
            }else if(nums[i] == 2){
                nums[i] = nums[right - 1];
                nums[right - 1] = 2;
                right --;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    // one pass in place solution
    void sortColors(int A[], int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }

    //better O(n)
    public void sortColorsBetter(int[] nums) {
        for(int i=0,j=0,k=0; k<nums.length; k++){
            int temp = nums[k];

            //assigning the current as max
            nums[k] = 2;

            // if original is less than 2 then it should be 1
            if(temp < 2){
                nums[j] = 1;
                j +=1;
            }

            // if original is less than 1 then it should be 0. The above if statement ensures that 1 - index
            // will always be greater than 0 - index
            if(temp < 1){
                nums[i] = 0;
                i += 1;
            }
        }
    }
    public static void sortColors3(int[] A,int n){
        int j = 0, k = n-1;
        for (int i=0; i <= k; i++) {
            if (A[i] == 0)
                swap(A[i], A[j++]);
            else if (A[i] == 2)
                swap(A[i--], A[k--]);
        }
    }
    private static void swap(int i,int j){

    }
    public static void main(String[] args) {
        int[] num = {1,1,2,2,0,0};
        sortColors(num);
    }
}
