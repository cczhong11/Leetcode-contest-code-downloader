public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean l = true;
        boolean r = true;
        for (int i=0; i<flowerbed.length; i++) {
            if (i<flowerbed.length-1)  r = flowerbed[i+1]==0 ? true : false;
            else r = true;
            if (i>0)  l = flowerbed[i-1]==0 ? true : false;
            else l = true;
            
            if(flowerbed[i]==0 && l && r && n>0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n==0;
    }
}