package test;

/**
 * Created by sjc on 2017/6/4.
 */
public class flower {
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        if(n==0) return true;
        if(flowerbed.length==1&&flowerbed[0]==1)return false;
        if(flowerbed.length==1&&flowerbed[0]==0){
            if(n<=1){
                return true;
            }else {
                return false;
            }
        }
        for(int i=1;i<flowerbed.length;i++){
            if(i==flowerbed.length-1){
                if(flowerbed[i-1]==0&&flowerbed[i]==0){
                    flowerbed[i]=1;
                    n--;
                    break;
                }
            }
            if(i==1){
                if(flowerbed[i-1]==0&&flowerbed[i]==0){
                    flowerbed[i-1]=1;
                    n--;
                    continue;
                }
            }
            if(flowerbed[i-1]==0&&flowerbed[i]==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;

    }
    public static void main(String[] args){
        int a[]=new int [5];
        a[1]=1;
        a[4]=1;
        boolean res=flower.canPlaceFlowers(a,0);
        System.out.println(res);
    }
}
