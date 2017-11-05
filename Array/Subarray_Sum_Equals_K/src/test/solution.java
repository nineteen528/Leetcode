package test;

/**
 * Created by sjc on 2017/6/15.
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

     Example 1:
     Input:nums = [1,1,1], k = 2
     Output: 2
     Note:
     The length of the array is in range [1, 20,000].
     The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class solution {
    public static int subarraySum(int[] nums, int k) {
        int res=0,sum=0,i,j;
        for(i=0;i<nums.length;i++){
            sum=0;
            for(j=i;j<nums.length;j++){
                sum+=nums[j];
                if(k==sum){
                    res++;
                }
            }
        }
        return res;
    }
    /* 优质解
     public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];            //对nums数组求前i个数的和
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : sum) {
            if (map.containsKey(num - k)) {                                        //当前和减去前几个值得和等于k则、、
                count += map.get(num - k);
            }
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        return count;
    }
     */
    public static void main(String[] args){
        int a[]={-1,-1,-1};
        System.out.println(solution.subarraySum(a,0));
    }
}
