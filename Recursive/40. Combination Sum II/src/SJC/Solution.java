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
            if(i > 0 && candidates[i] == candidates[i - 1]) continue;
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
        if(sum > target) return;
        for(int i = index + 1;i < candidates.length;i++){
            if(i > index + 1 && candidates[i] == candidates[i - 1])continue;
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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        helper(candidates, 0, target, sol, ret);
        return ret;
    }
    //better solution
    private void helper(int[] candidates, int idx, int target, List<Integer> sol, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(sol));
            return;
        } else if (target > 0) {
            for(int i = idx; i<candidates.length; ++i) {
                if (candidates[i] > target) {
                    break;
                }
                if (i>idx && candidates[i-1] == candidates[i]) {
                    continue;
                }
                sol.add(candidates[i]);
                helper(candidates, i+1, target - candidates[i], sol, ret);
                sol.remove(sol.size()-1);
            }
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

        boolean flag = isPalindrome(121);
        System.out.println(flag);
    }
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x >=0 && x <= 9) return true;
        if(x % 10 == 0) return false;
        int pow = 10;
        while (x >= pow){
            if(x / pow <= 9) break;
            pow = pow * 10;
        };
        int left = pow;
        int right = 1;
        while (left > right){
            if(x / left % 10 != x / right % 10){
                return false;
            }
            left /= 10;
            right *= 10;
        }
        return true;
    }
}
