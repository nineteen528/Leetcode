package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sjc on 2017/6/19.
 * Total Accepted: 2687
 Total Submissions: 8649
 Difficulty: Easy
 Contributors:
 fallcreek
 Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

 Example 1:
 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]
 Output: 4
 Explanation:
 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 */
public class solution {
    public static int maxDistance(List<List<Integer>> arrays){
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
        int secmin=10001;
        int secmax=-10001;
        int submin=0;
        int submax=0;
        for(int i=1;i<arrays.size();i++){
            if(min>arrays.get(i).get(0)){
                min=arrays.get(i).get(0);
                submin=i;
            }
            if(max<arrays.get(i).get(arrays.get(i).size()-1)) {
                max=arrays.get(i).get(arrays.get(i).size()-1);
                submax=i;
            }
        }
        if(submax==submin){
            for(int i=0;i<arrays.size();i++){
                if(i==submax){
                    continue;
                }
                if(secmin>arrays.get(i).get(0)){
                    secmin=arrays.get(i).get(0);
                }
                if(secmax<arrays.get(i).get(arrays.get(i).size()-1)) {
                    secmax=arrays.get(i).get(arrays.get(i).size()-1);
                }
            }
            return max-secmin>secmax-min ? max-secmin:secmax-min;
        }
        return max-min;
    }
    /*
    public static int maxDistance(int[][] list) {
        int res=0,min_val=list[0][0],max_val=list[0][list[0].length-1];
        for(int i=1;i<list.length;i++)
        {
            res=Math.max(res,Math.max(Math.abs(list[i][list[i].length-1]-min_val),Math.abs(max_val-list[i][0])));
            min_val=Math.min(min_val,list[i][0]);
            max_val=Math.max(max_val,list[i][list[i].length-1]);
        }
        return res;
    }
     */
    public static void main(String[] args){
       // List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> list=new ArrayList<List<Integer>>() {
        };
        List<Integer> temp1=new ArrayList();
        List<Integer> temp2=new ArrayList();
        temp1.add(1);
        temp1.add(4);
        list.add(temp1);
        temp2.add(0);
        temp2.add(5);
        list.add(temp2);
        System.out.println(solution.maxDistance(list));
    }
}
