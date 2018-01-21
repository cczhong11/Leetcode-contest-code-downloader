public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int nn = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ( flowerbed.length == 1) {
                   flowerbed[i] = 1; 
                   nn--; 
                }
                else if (i == 0 && i+1 < flowerbed.length && flowerbed[i+1] == 0) {
                   flowerbed[i] = 1; 
                   nn--;
                } else if (i == flowerbed.length-1 && i-1 >= 0 && flowerbed[i-1] == 0) {
                   flowerbed[i] = 1;  
                   nn--;
                } else if (i+1 < flowerbed.length && i-1 >= 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0) {
                    flowerbed[i] = 1;
                    nn--;
                }
            }
        }
        
        if (nn <= 0) {
            return true;
        }
        
        return false;
        
    }
}