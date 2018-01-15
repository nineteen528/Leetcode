package test;

/**
 * Created by SJC on 2017/11/26.
 */
public class solution {
    //DP方法
    public static int dp(int [] s,int [] e){
        int len =s.length;
        int [][] c = new  int[len][len];
        for(int i = 0;i < len-2;i++){
            if(s[i+1] >= e[i] && e[i+1]<=s[i+2]){
                c[i][i+2] = 1;
            }
        }
        for(int i= 2;i < len;i++){
            for(int j = i-2;j >= 0;j--){
                for (int k = j+2;k < i-1;k++){
                    c[j][i] = Math.max(c[j][i],c[j][k]+c[k][i]+1);
                }
            }
        }
        return c[0][11];
    }
    //Greedy 递归方法
    public static String  recursive_greedy(int [] s,int [] e,int k ,int n ){
        int m = k+1;
        while (m < n && s[m] < e[k]){
            m++;
        }
        if(m < n){
            return "X: "+m + recursive_greedy(s,e,m,n);
        }else {
            return "";
        }
    }
    //Greedy 迭代方法
    public static String iterGeedy(int[] s,int [] e,int k ,int n ){
        StringBuilder ss = new StringBuilder();
        for(int i = k+1;i < n;i++){
            if(s[i] >= e[k]){
                ss.append(" X: "+i);
                k = i;
            }
        }
        return ss.toString();
    }
    public static void main(String[] args) {
        int [] s ={0,1,3,0,5,3,5,6,8,8,2,12};
        int [] end ={0,4,5,6,7,9,9,10,11,12,14,16};
        System.out.println(iterGeedy(s,end,0,12));
    }
}
