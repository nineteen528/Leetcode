package test;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * Created by sjc on 2017/6/22.
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.

 Example 1:
 Input: tasks = ['A','A','A','B','B','B'], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 *
 */
public class solution {
    public static int leastInterval(char[] tasks, int n) {
        int res=0,i;
        int [] count=new int[26];
        for(char temp:tasks){
            count[temp-'A']++;
        }
        Arrays.sort(count);
        for(i=25;i>=0&&count[i]==count[25];i--){

        }
        return Math.max(tasks.length,(n+1)*(count[25]-1)+25-i);
    }
    public static void main(String[] args){
        char [] a={'A','A','B','B','C','C'};
        System.out.println(solution.leastInterval(a,1));
    }
}
