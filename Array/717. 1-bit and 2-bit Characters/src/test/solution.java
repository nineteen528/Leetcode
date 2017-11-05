package test;

/**
 * Created by SJC on 2017/11/3.
 */
public class solution {
    public static boolean isOneBitCharacter(int[] bits) {
//        if(bits.length==1) return true;
//        if(bits[bits.length-2]==0) return true;
//        for(int i=0;i<bits.length;i++){
//            if(bits[i]==1){
//
//            }
//        }
        int i=0;
        while(i<bits.length-1){
            if(bits[i]==0){
                i++;
            }else {
                i+=2;
            }
        }
        return i==bits.length-1;
    }
    public static void main(String[] args) {
        int [] bits = {1,0,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
