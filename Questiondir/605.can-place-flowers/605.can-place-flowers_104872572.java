public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last=-2;
        for(int i=0;i<=flowerbed.length;i++){
            if(i==flowerbed.length){
                n=n-(i-last-1)/2;
                if(n<=0){
                    return true;
                }
            }
            else if(flowerbed[i]==1){
                if(last==-1){
                    n=n-(i-last-1)/2;
                }
                else{
                    n=n-(i-last-2)/2;
                }
                last=i;
                if(n<=0){
                    return true;
                }
            }
        }
        return false;
    }
}