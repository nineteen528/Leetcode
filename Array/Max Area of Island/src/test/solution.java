package test;


/**
 * Created by SJC on 2017/10/14.
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 Example 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6
 */
public class solution {

    public static int maxAreaOfIsland(int[][] grid){
        int res=0;
       // solution aa=new solution();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res= Integer.max(res,DFS(grid,i,j));
            }
        }
        return res;
    }
    public static int DFS(int[][] grid,int i,int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==1){
            grid[i][j]=0;
            return 1+DFS(grid,i-1,j)+DFS(grid,i,j+1)+DFS(grid,i+1,j)+DFS(grid,i,j-1);
        }
        return 0;
    }
    public static void main(String[] args) {
        int a[][]={{0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                    {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(solution.maxAreaOfIsland(a));
    }


}
