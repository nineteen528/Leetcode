package SJC;

/**
 * Created by SJC on 2018/1/6.
 *
 Given two strings representing two complex numbers.

 You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

 Example 1:
 Input: "1+1i", "1+1i"
 Output: "0+2i"
 Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 Example 2:
 Input: "1+-1i", "1+-1i"
 Output: "0+-2i"
 Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 Note:

 The input strings will not have extra blank.
 The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class Solution {
    public static String complexNumberMultiply(String a, String b) {
        if(a == null || b == null || a.length() == 0 || b.length() == 0) return null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        int index = a.indexOf('+');
        s1 = a.substring(0,index);
        s2 = a.substring(index + 1,a.length() - 1);
        index = b.indexOf('+');
        s3 = b.substring(0,index);
        s4 = b.substring(index + 1,b.length() - 1);

        int left = Integer.parseInt(s1) * Integer.parseInt(s3) - Integer.parseInt(s2) * Integer.parseInt(s4);
        int right = Integer.parseInt(s1) * Integer.parseInt(s4) + Integer.parseInt(s2) * Integer.parseInt(s3);
        return left+"+"+right+"i";
    }
    //better
    public String complexNumberMultiply2(String a, String b) {

        int i1=a.indexOf("+");
        int i2=b.indexOf("+");
        int x1=Integer.parseInt(a.substring(0,i1));
        int x2=Integer.parseInt(b.substring(0,i2));
        int y1=Integer.parseInt(a.substring(i1+1,a.length()-1));
        int y2=Integer.parseInt(b.substring(i2+1,b.length()-1));

        int result1=x1*x2-y1*y2;
        // System.out.println(result1);
        int result2=x1*y2+x2*y1;
        String rString=result1+"+"+result2+"i";
        return rString;
        // System.out.println(rString);

    }
    public static void main(String[] args) {
        String a = "20+22i";
        String b = "-18+-10i";
        System.out.println(complexNumberMultiply(a,b));
    }
}
