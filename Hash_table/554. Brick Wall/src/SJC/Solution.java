package SJC;
import java.util.*;
/**
 * Created by SJC on 2017/12/15.
 */
public class Solution {
    public static int leastBricks(List<List<Integer>> wall){
        int R = wall.size(), min = R;
        if (R == 1 && wall.get(0).size() > 1) return 0;

        Queue<int []> queue = new PriorityQueue<>((a,b)->(a[2] - b[2]));
        int num = 0;
        int max = 0;
        for(List<Integer> ll : wall){
            queue.add(new int[]{num,0,ll.get(0)});
            num++;
        }
        //System.out.println("hh");
        while (!queue.isEmpty()){
            int end = queue.peek()[2], count = 0;

            while (!queue.isEmpty() && queue.peek()[2] == end) {
                count++;
                int[] brick = queue.poll();
                if (brick[1] < wall.get(brick[0]).size() - 1) {
                    queue.add(new int[] {brick[0],brick[1]+1,brick[2] + wall.get(brick[0]).get(brick[1]+1)});
                }
            }

            if (!queue.isEmpty()) {
                min = Math.min(min, R - count);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> la = new ArrayList<>();
        la.add(1);
        la.add(2);
        la.add(2);
        la.add(1);
        List<Integer> lb = new ArrayList<>();
        lb.add(3);
        lb.add(1);
        lb.add(2);
        List<Integer> lc = new ArrayList<>();
        lc.add(1);
        lc.add(3);
        lc.add(2);
        List<Integer> ld = new ArrayList<>();
        ld.add(2);
        ld.add(4);
        List<Integer> le = new ArrayList<>();
        le.add(3);
        le.add(1);
        le.add(2);
        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        ll.add(3);
        ll.add(1);
        ll.add(1);
        int a[] = new int[]{1,2,3};
        wall.add(la); wall.add(lb); wall.add(lc); wall.add(ld); wall.add(le); wall.add(ll);
        System.out.println(leastBricks(wall));
    }
    //better solution
    public static int leastBricks2(List<List<Integer>> wall){
        Map<Integer, Integer> map = new HashMap<>();
        int sum, max=0, count=0;
        for(List<Integer> list: wall){
            sum=0;
            for(int i=0; i<list.size()-1; i++){
                sum += list.get(i);
                if(map.containsKey(sum)){
                    count = map.get(sum)+1;
                } else{
                    count = 1;
                }
                map.put(sum, count);
                max = Math.max(max, count);
            }
        }
        return wall.size()-max;
    }
}
