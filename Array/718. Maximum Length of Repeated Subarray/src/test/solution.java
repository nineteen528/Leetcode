package test;

/**
 * Created by SJC on 2017/11/3.
 */
public class solution {
    public static int findLength(int[] A, int[] B) {
        int dp[][] = new int[A.length+1][B.length+1];
        int max=0;
        for(int i=1;i<A.length+1;i++){
            for(int j=1;j<B.length+1;j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] A = {1,2,3,2,1};
        int [] B = {3,2,1,4,7};
        System.out.println(findLength(A,B));
    }
}
  /*    better solution 空间复杂度O(n)
  public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, max = 0;
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i++)
            for(int j = m; j > 0; j--)
                max = Math.max(max, dp[j] = A[i-1] == B[j-1] ? dp[j-1] + 1 : 0);
        return max;
    }
    */