public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i=0; i<flowerbed.length & n > 0; i++) {
            if (flowerbed[i] == 1)
                continue;
                
            if ((i>0 && flowerbed[i-1] == 0 || i==0) && (i<flowerbed.length-1 && flowerbed[i+1] == 0 || i==flowerbed.length-1)) {
                n--;
                flowerbed[i] = 1;
            }    
        }
        
        if (n<=0)
            return true;
        else
            return false;
    }
}