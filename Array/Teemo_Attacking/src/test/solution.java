package test;

/**
 * Created by sjc on 2017/7/11.
 * In LLP world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.

 You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 */
public class solution {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0||duration==0) return 0;
        int res=0;
        for(int i=1;i<timeSeries.length;i++){
            res+=Math.min(timeSeries[i]-timeSeries[i-1],duration);
        }

        return res+duration;
    }
    public static void main(String[] args){
        int []a={1,2};
        int b=2;
        System.out.println(solution.findPoisonedDuration(a,b));
    }
}

/* public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0, end = 0;
        for(int t: timeSeries){
            if(end>t){ res-=(end-t); }
            res += duration;
            end = t+duration;
        }
        return res;
    }
*/