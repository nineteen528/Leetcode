package MC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by SJC on 2017/12/12.Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

 For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

 Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

 */
public class solution {
    public static int[] dailyTemperatures(int[] temperatures) {             //利用栈解决
        int [] ans = new int [temperatures.length];
        int len = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < len;i++){
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {      //第496题
        int [] ans = new int [nums1.length];
        Map<Integer,Integer> map = new HashMap();
        Stack<Integer> s = new Stack();
        for(int i = 0;i < nums2.length;i++){
            while(!s.empty() && nums2[i] > s.peek()){
                map.put(s.pop(),nums2[i]);
            }
            s.push(nums2[i]);
        }
        for(int i = 0;i <nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] a = {73, 74, 75, 71, 69, 72, 76, 73};int []c =(int[]) a.clone();Arrays.sort(c);
        int aa [] = dailyTemperatures(a);
        System.out.println(Arrays.toString(aa));
    }
}
