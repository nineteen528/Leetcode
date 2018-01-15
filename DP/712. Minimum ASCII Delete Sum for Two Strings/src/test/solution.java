package test;

public class solution {
    public static int minimumDeleteSum(String s1, String s2) {
        int sum=0;
        int max=0;
        for (int i=0;i<s1.length();i++){
            sum+=s1.charAt(i);
        }
        for (int i=0;i<s2.length();i++){
            sum+=s2.charAt(i);
        }
        System.out.println(sum);
        int [][] A = new int [s1.length()+1][s2.length()+1];

        for (int i = 0;i<s1.length();i++){
            for (int j=0;j<s2.length();j++){
                if (s1.charAt(i)==s2.charAt(j)){
                    A[i+1][j+1]=A[i][j]+s1.charAt(i)*2;
                    //max = Math.max(max,A[i+1][j+1]);
                }else{
                    A[i+1][j+1] = Math.max(A[i+1][j],A[i][j+1]);
                }
            }
        }
        return sum-A[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";
        a = "sjfqkfxqodw";
        b = "fxymelgo";
       // System.out.println(a.charAt(0));
        System.out.println(minimumDeleteSum(a,b));
    }
}
