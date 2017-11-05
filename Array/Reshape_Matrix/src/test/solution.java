package test;

/**
 * Created by sjc on 2017/6/6.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

 The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

 If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
public class solution {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int tr=nums.length;
        int tc=nums[0].length;
        int k=0;
        if(r*c!=tr*tc){
            return nums;
        }
        int temp[]=new int[r*c];
        for(int i=0;i<tr;i++) {
            for (int j = 0; j < tc; j++) {
                temp[k++] = nums[i][j];
            }
        }
        k=0;
        int res[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j]=temp[k++];
            }
        }
        return res;
    }
    public static void main(String[] args){
        int a[][]=new int[2][2];
        a[0][0]=1;a[0][1]=2;a[1][0]=3;a[1][1]=4;
        int res[][]=matrixReshape(a,4,1);
        for(int i=0;i<res.length;i++){
           for(int j=0;j<res[0].length;j++){
               System.out.println(res[i][j]);
           }
        }

    }
}



/*
public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res=new int[r][c];
        if(nums.length==0 || r*c!=nums.length*nums[0].length)
            return nums;
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[0].length;j++)
            {
               queue.add(nums[i][j]);
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
               res[i][j]=queue.remove();
            }
        }
        return res;
    }

 */
