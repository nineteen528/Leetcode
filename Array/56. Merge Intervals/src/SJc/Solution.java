package SJc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SJC on 2018/1/15.
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].


 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public static List<Interval> merge2(List<Interval> intervals){
        if(intervals == null || intervals.size() == 0) return new ArrayList();
        List<Interval> ans = new ArrayList();
        ans.add(intervals.get(0));
        for(int i = 1;i < intervals.size();i++){
            int j = ans.size() - 1;
            //System.out.println(j);
            while(j >= 0 && intervals.get(i).end < ans.get(j).start){
                j--;
            }
            if(j == -1){
                ans.add(0,intervals.get(i));
                continue;
            }
            int k = 0;
            while (k < ans.size() && intervals.get(i).start > ans.get(k).end){
                k++;
            }
            if(k == ans.size()){
                ans.add(intervals.get(i));
                continue;
            }
            if(k > j){
                ans.add(k,intervals.get(i));
            }
            int min = Math.min(ans.get(k).start,intervals.get(i).start);
            int max = Math.max(ans.get(j).end,intervals.get(i).end);
            ans.set(k,new Interval(min, max));
            for(int xx = k + 1;xx <= j;xx++){
                ans.remove(k+1);
            }
        }
        return ans;
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
    public List<Interval> merge3(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int count = 0;
        for(Interval interval : intervals){
            start[count] = interval.start;
            end[count] = interval.end;
            count = count + 1;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < intervals.size(); i++) { // j is start of interval.
            if (i == intervals.size() - 1 || start[i + 1] > end[i]) {
                res.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<Interval> tmp = new ArrayList<>();
        tmp.add(new Interval(4,5));
        tmp.add(new Interval(2,4));
        tmp.add(new Interval(4,6));
        tmp.add(new Interval(3,4));
        tmp.add(new Interval(0,0));
        tmp.add(new Interval(1,1));
        tmp.add(new Interval(3,5));
        tmp.add(new Interval(2,2));
        for(Interval interval : merge2(tmp)){
            System.out.println(interval.start + ":" + interval.end);
        }
        List<String> a = new ArrayList<>();
        a.add("sd");
        a.add(0,"sdd");
        System.out.println(a.get(1));
    }
}
