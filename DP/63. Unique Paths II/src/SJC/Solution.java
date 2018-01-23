package SJC;

import java.util.Arrays;

/**
 * Created by SJC on 2018/1/18.
 */
public class Solution {
    public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];
        for(int xx = 0;xx < n;xx++){
            if(obstacleGrid[0][xx] == 0){
                ans[0][xx] = 0;
                continue;
            }
            ans[0][xx] = xx > 0 ? ans[0][xx - 1] : 1;
        }
       for(int xx = 0;xx < m;xx++){
           if(obstacleGrid[xx][0] == 0){
               ans[xx][0] = 0;
               continue;
           }
           ans[xx][0] = xx > 0 ? ans[xx - 1][0] : 1;
       }
       for(int i = 1;i < m;i++){
           for(int j = 1;j < n;j++){
               if(obstacleGrid[i][j] == 1){
                   ans[i][j] = 0;
                   continue;
               }
               ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
           }
       }
        return ans[m - 1][n - 1];
    }
    public static void main(String[] args) {

    }
}
