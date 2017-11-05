package test;

import java.util.HashSet;
import java.util.Set;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by sjc on 2017/6/8.
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].

 Sets S[K] for 0 <= K < N are defined as follows:

 S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

 Sets S[K] are finite for each K and should NOT contain duplicates.

 Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

 */
public class solution {
    public static int arrayNesting(int[] nums) {
        /*
        int temp;
        Set set=new HashSet();
        int res=0;
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
           for(int j=0;j<nums.length;j++){
               if(!set.add(temp)){
                   break;
               }
               temp=nums[temp];
           }
           if(res<set.size()){
               res=set.size();
           }
           set.clear();
        }
        return res;*/

        int i,j,k=0;
        int res=0;
        for( i=0;i<nums.length;i++){
            if(nums[i]<0)continue;
            k=0;
            for(j=i;nums[j]>=0;k++){
                int temp=nums[j];
                nums[j]=-1;
                j=temp;
            }
            res=Integer.max(k,res);
        }
        return res;

    }
    public static void main(String[] args){
        int nums[]={5,4,0,3,1,6,2};
        System.out.println(solution.arrayNesting(nums));
    }
}
