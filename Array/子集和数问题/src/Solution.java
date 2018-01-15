import org.omg.CORBA.MARSHAL;

/**
 * Created by SJC on 2017/12/20.
 */
public class Solution {
    //方法1       use a[i][j] 求a[i][j+1]
    public static int subSumArray(int [] a){
        int [][]ans = new int[1][a.length];
        ans[0][0] = a[0];
        int i = 1;
        while (i < a.length) {
            ans[0][i] = ans[0][i-1];
            int sum = a[i];
            for (int j = i - 1; j >= 0; j--) {
                ans[0][i] = Math.max(ans[0][i], sum += a[j]);
            }
            i++;
        }
        return ans[0][a.length-1];
    }
    //方法2  递归求解    左半部分的子集和最大    通过中间点的最大子集和    右半部分的最大子集和
    public static int subSumArray2(int [] a,int low,int high){
        if(low == high){
            return a[low];
        }
        int middle = (low + high) / 2;
        int left = subSumArray2(a,low,middle);
        int right = subSumArray2(a,middle+1,high);
        int mm = throughMiddle(a,low,middle,high);
        int s = Math.max(left,right);
        return Math.max(s,mm);
    }
    public static int throughMiddle(int [] a,int left,int middle,int right){
        int s1 = Integer.MIN_VALUE;
        int s2 = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = middle;i >= left;i--){
            sum1 += a[i];
            s1 = Math.max(s1,sum1);
        }
        for (int i = middle+1;i <= right;i++){
            sum2 += a[i];
            s2 = Math.max(s2,sum2);
        }
        return s1 + s2;
    }
    public static void main(String[] args) {
        int []a = {1,-1,2,4,-2,6,9,5};
        System.out.println(subSumArray(a));
        System.out.println(subSumArray2(a,0,a.length-1));
    }
}
