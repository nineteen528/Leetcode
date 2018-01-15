package SJC;

import org.omg.CORBA.MARSHAL;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by SJC on 2018/1/14.
 * 542. 01 Matrix
 DescriptionHintsSubmissionsDiscussSolution
 DiscussPick One
 Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.
 */
public class Solution {
    public static int[][] updateMatrix(int[][] matrix) {
        if(matrix == null) return new int[0][0];
        int[][] ans = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                //visited = new boolean[matrix.length][matrix[0].length];
                bfs(matrix,visited,i,j,ans);
            }
        }
        return ans;
    }
    private static int bfs(int[][] matrix,boolean[][] visited,int i,int j,int[][] ans){
        if(matrix[i][j] == 0) return 0;
        if(visited[i][j]) return ans[i][j];
        int min = Integer.MAX_VALUE;
        if(i > 0){
            visited[i][j] = true;
            min = Math.min(min,bfs(matrix,visited,i - 1,j,ans));
            visited[i][j] = false;
        }
        if(i < matrix.length - 1){
            visited[i][j] = true;
            min = Math.min(min,bfs(matrix,visited,i + 1,j,ans));
            visited[i][j] = false;
        }
        if(j > 0){
            visited[i][j] = true;
            min = Math.min(min,bfs(matrix,visited,i,j - 1,ans));
            visited[i][j] = true;
        }
        if(j <= matrix[i].length - 2){
            visited[i][j] = true;
            min =Math.min(min,bfs(matrix,visited,i,j + 1,ans));
            visited[i][j] = false;
        }
        ans[i][j] =  1 + min;
        visited[i][j] = true;
        return ans[i][j];
    }
    //bfs
    public static int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }
    public static List<List<Integer>> updateMatrix3(List<List<Integer>> matrix) {
        List<List<Integer>> answer = new LinkedList();
        if(matrix.size() == 0) return answer;
        int[][] array = new int[matrix.size()][matrix.get(0).size()];
        int i = 0, j = 0;
        for(List<Integer> list : matrix) {
            for(Integer x : list) {
                if(x == 0) {
                    array[i][j] = 0;
                }
                else {
                    int left = Integer.MAX_VALUE - 1, top = Integer.MAX_VALUE - 1;
                    if(i - 1 >= 0) top = array[i - 1][j];
                    if(j - 1 >= 0) left = array[i][j - 1];
                    array[i][j] = Math.min(Integer.MAX_VALUE - 1, Math.min(top, left) + 1);
                }
                j++;
            }
            j = 0;
            i++;
        }
        for(int k = array.length - 1; k >= 0; k--) {
            for(int m = array[0].length - 1; m >= 0; m--) {
                if(array[k][m] != 0 && array[k][m] != 1) {
                    int down = Integer.MAX_VALUE - 1, right = Integer.MAX_VALUE - 1;
                    if(k + 1 < array.length) down = array[k + 1][m];
                    if(m + 1 < array[0].length) right = array[k][m + 1];
                    array[k][m] = Math.min(array[k][m], Math.min(down, right) + 1);
                }
            }
        }
        for(int[] l : array) {
            List<Integer> tmp = new LinkedList();
            for(int n : l) {
                tmp.add(n);
            }
            answer.add(tmp);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] s = {{0},{1}};
        int[][] v = updateMatrix(s);
        for(int i = 0;i < v.length;i++){
            for(int j = 0;j < v[i].length;j++){
                System.out.printf("" + v[i][j]);
            }
        }
    }
}
