package SJC;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by SJC on 2017/12/20.
 */
class MyCalendar{
    public List<Integer> sList;
    public List<Integer> eList;
    public MyCalendar() {
        sList = new LinkedList<>();
        eList = new LinkedList<>();
    }
    public boolean book(int start, int end) {
        int i = 0;
        if(sList.size() == 0){
            sList.add(start);
            eList.add(end);
            return true;
        }else {
            int low = 0,high = eList.size()-1;
            int middle = (low + high) / 2;
            while (low <= high){
                middle = (low + high) / 2;
                if(end <= sList.get(middle)){
                    i =middle;
                    high = middle -1;
                }else {
                    low = middle+1;
                }
            }



            //for ( i = 0;i < sList.size();i++){
                if(end <= sList.get(i)){
                    if(i == 0 || start >= eList.get(i-1)){
                        if(i==0){
                            if(end == sList.get(i)){
                                sList.set(i,start);
                                return true;
                            }
                            else{
                                sList.add(0,start);
                                eList.add(0,end);
                                return true;
                            }
                        }else{
                            if(end == sList.get(i)){
                                if(start == eList.get(i-1)){
                                    sList.remove(i);
                                    eList.remove(i-1);
                                    return true;
                                }else{
                                    sList.set(i,start);
                                    return true;
                                }
                            }else{
                                if(start == eList.get(i-1)){
                                    eList.set(i-1,end);
                                    return true;
                                }else{
                                    sList.add(i,start);
                                    eList.add(i,end);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }

           // if(i == sList.size()){
                if(start == eList.get(eList.size()-1)){
                    eList.set(eList.size()-1,end);
                    return true;
                }
                if(start > eList.get(eList.size()-1)){
                    sList.add(start);
                    eList.add(end);
                    return true;
                }
           // }
        //}
        return false;
    }
}
public class Solution {
    public static int subSumArray(int [] a){
        int [][]ans = new int[1][a.length];
        ans[0][0] = a[0];
        int i = 1;
        while (i < a.length) {
            int sum = a[i];
            for (int j = i - 1; j >= 0; j--) {
                ans[0][i] = Math.max(ans[0][i], sum += a[j]);
            }
            i++;
        }
        return ans[0][a.length-1];
    }
    public static void main(String[] args) {
        MyCalendar ss = new MyCalendar();
        System.out.println(ss.book(0,1));
        System.out.println(ss.book(0,9));
        System.out.println(ss.book(2,5));

    }
}
//better solution 二分法
/*
    public boolean book(int start, int end) {
        int s=0, e=bookings.size()-1;
        while (s<=e){
            int mid=s+(e-s)/2;
            int[] bk=bookings.get(mid);
            if (bk[0]==start){
                return false;
            }else if (bk[0]>start){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        if (s>0 && start<bookings.get(s-1)[1])
            return false;

        if (s<bookings.size() && end>bookings.get(s)[0])
            return false;

        bookings.add(s, new int[]{start, end});
        return true;
    }
*/
//treemap
    /*class MyCalendar {

        TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer floorKey = calendar.floorKey(start);
            if (floorKey != null && calendar.get(floorKey) > start) return false;
            Integer ceilingKey = calendar.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return false;

            calendar.put(start, end);
            return true;
        }
    }*/