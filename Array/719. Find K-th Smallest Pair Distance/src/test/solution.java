package test;

/**
 * Created by SJC on 2017/11/2.
 */
public class solution {
    public static int smallestDistancePair(int[] nums, int k) {
        int [] res =new int [1000000];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                res[Math.abs(nums[i]-nums[j])]++;
            }
        }
        int i=0;
        while (k>0){
            k-=res[i];
            if(k<=0) break;
            i++;
        }
        return i;
    }
    public static void main(String[] args) {
        int [] nums = {1,6,1};
        int k=1;
        System.out.println(smallestDistancePair(nums,k));
    }
}

/*  better solution 二分法
  public int smallestDistancePair(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        int low = 0, high = 100000000;
        while(low < high){
            int mid = low + (high-low)/2;
            int p = 0;
            int ct = 0;
            for(int i = 0;i < n;i++){
                while(a[i] - a[p] > mid){
                    p++;
                }
                ct += i-p;
            }
            if(ct < k){
                low = mid + 1;
            }else{
                high = mid;                                         //不停地向左移，直到最小的满足条件的那个值，正好是第k小对应的差
            }
        }
        return low;
    }*/
