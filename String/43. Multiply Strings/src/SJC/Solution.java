package SJC;

/**
 * Created by SJC on 2018/1/12.
 */
public class Solution {
    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1 == "" || num2 == "") return "";
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length(),len2 = num2.length();
        StringBuffer bs = new StringBuffer();
        int[] record = new int[len1 + len2 - 1];
        for(int i = len1 - 1;i >= 0;i--){
            for(int j = len2 - 1;j >= 0;j--){
                record[len1 - 1 - i +  len2 - 1 - j ] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int pre = 0;
        for(int i = 0;i < len1 + len2 - 1;i++){
            //System.out.println(record[i]);
            bs.append((record[i] + pre) % 10 + "");
            //System.out.println((char)((record[i] + pre) % 10));
            pre = (record[i] + pre) / 10 ;
        }
        if(pre != 0) bs.append(pre + "");
        return bs.reverse().toString();
    }
    //better
    /*
    public String multiply(String num1, String num2) {
        swapStr(num1, num2);
        int[] res= new int[num1.length()+num2.length()+1];
        int offset=0;
        for(int i=num2.length()-1; i>=0; i--){
            addToArr(num2.charAt(i)-'0', num1, offset, res);
            offset++;
            //show(res);
        }
        moveForward(res);
        int index=0;
        StringBuilder sb= new StringBuilder();
        while(index<res.length && res[index]==0) index++;
        while(index<res.length){
            sb.append(res[index++]);
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
    public void swapStr(String num1, String num2){
        if(num1.length()>num2.length()) return;
        String temp= num1;
        num1= num2;
        num2= temp;
    }
    public void addToArr(int c, String num, int offset, int[] res){
        for(int i= num.length()-1; i>=0; i--){
            int val=(num.charAt(i)-'0')*c;
            res[res.length-offset-1]+=val;
            offset++;
        }
    }
    public void show(int[] res){
        for(int num: res){
            System.out.println(num);
        }
    }
    public void moveForward(int[] res){
        for(int i=res.length-1; i>0; i--){
            res[i-1]+=res[i]/10;
            res[i]= res[i]%10;
        }
    }
    */
    public static void main(String[] args) {
        System.out.println(multiply("12","12"));
    }
}
