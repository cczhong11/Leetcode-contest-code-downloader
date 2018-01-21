public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int len = flowerbed.length;
        
        for (int i = 0; i < len - 1; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }
        
        if (len >= 2) {
            if (flowerbed[len-1] == 0 && flowerbed[len-2] == 0) {
                flowerbed[len-1] = 1;
                n--;
            }
        } else {
            if (flowerbed[len-1] == 0) {
                flowerbed[len-1] = 1;
                n--;                
            }
        }
        
        if (n <= 0) return true;
        else return false;
    }
}