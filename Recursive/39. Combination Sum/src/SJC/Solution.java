package SJC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SJC on 2018/1/8.
 */
public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates.length == 0) return ans;
        Arrays.sort(candidates);
        for(int i = 0;i < candidates.length;i++){
            List<Integer> record = new ArrayList<>();
            record.add(candidates[i]);
            if(candidates[i] == target){
                ans.add(record);
                continue;
            }
            combination(i,candidates[i],candidates,record,ans,target);
        }
        return ans;
    }
    public static void combination(int index,int sum,int[] candidates,List<Integer> record,List<List<Integer>> ans,int target){
        //List<Integer> tmp = new ArrayList<>(record);
//        if(sum == target){
//            ans.add(tmp);
//            return;
//        }
        if(sum > target) return;
        for(int i = index + 1;i < candidates.length;i++){
            if(sum + candidates[i] == target){
                List<Integer> tmp = new ArrayList<>(record);
                tmp.add(candidates[i]);
                ans.add(tmp);
                return;
            }else if(sum + candidates[i] < target){
                List<Integer> tmp = new ArrayList<>(record);
                tmp.add(candidates[i]);
                combination(i,sum + candidates[i],candidates,tmp,ans,target);
            }else {
                return;
            }
        }
    }
    //better solution
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> ans = new ArrayList<>();
        search(candidates, 0, target, new Integer[target], 0, ans);
        return ans;
    }

    private void search(int[] candidates, int st,
                        int target,
                        Integer[] paper, int len,
                        List<List<Integer>> ans) {
        if (target == 0) {
            final Integer[] temp = new Integer[len];
            System.arraycopy(paper, 0, temp, 0, len);
            ans.add(Arrays.asList(temp));
            return;
        }

        for(int i=st; i<candidates.length; i++) {
            if (i>st && candidates[i] == candidates[i-1]) continue;
            if (target < candidates[i]) break;
            paper[len] = candidates[i];
            search(candidates, i, target-candidates[i], paper, len+1, ans);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int target = 5;
        ArrayList<Integer> a = new ArrayList();
        a.add(1);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        System.out.println(a.toString().equals(b.toString()));
        List<List<Integer>> list = combinationSum(arr,target);
        for(List<Integer> ll : list){
            for(int num : ll)
                System.out.print(num + " ");
            System.out.println();
        }
    }
//    if(sum > target) return;
//        if(sum + candidates[index] == target){
//        tmp.add(candidates[index]);
//        ans.add(tmp);
//        return;
//    }
//        else if(sum + candidates[index] < target){
//        tmp.add(candidates[index]);
//        for(int i = index;i < candidates.length;i++){
//            combination(i,sum + candidates[i],candidates,tmp,ans,target);
//        }
//    }else {
//        return;
//    }
}
