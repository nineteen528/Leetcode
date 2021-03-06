package SJC;

/**
 * Created by SJC on 2018/1/23.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 */
public class Solution {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid[0].length == 0) return 0;
        int sum = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == '1'){
                    sum++;
                    reset(grid,i,j);
                }
            }
        }
        return sum;
    }
    private static void reset(char[][] a,int i,int j){
        if(i >= a.length || i < 0 || j < 0 || j > a[0].length - 1 ) return;
        if(a[i][j] == '1'){
            a[i][j] = '0';
            reset(a,i - 1,j);
            reset(a,i + 1,j);
            reset(a,i,j - 1);
            reset(a,i,j + 1);
        }
    }
    public static void main(String[] args) {

    }
}
