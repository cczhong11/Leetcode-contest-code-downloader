public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < n) return false;
        if (n == 0) return true;
        
        // just pack as we go
        // start from position 0, 
        boolean pre1 = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) pre1 = true;
            else {
                // current is zero
                
                // if prev is 1, can not pack
                if (pre1) {
                    pre1 = false;
                }else {
                    // previous is not 1, then check next
                    if (i == flowerbed.length - 1 || flowerbed[i+1] == 0) {
                        // pack at i
                        n--;
                        if (n == 0) return true;
                        
                        pre1 = true;
                    }else {
                        pre1 = false;
                    }
                }
            }
        }
        return false;
    }
}