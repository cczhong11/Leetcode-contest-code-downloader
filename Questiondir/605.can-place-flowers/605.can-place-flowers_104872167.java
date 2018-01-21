public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n > flowerbed.length/2 + 1) {
            return false;
        }
        
        for (int i = 0; n > 0 && i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && check(flowerbed, i - 1) && check(flowerbed, i + 1))  {
                flowerbed[i] = 1;
                n--;
            }
        }
        
        return n == 0;
    }
    
    private boolean check(int[] flowerbed, int i) {
        if (i < 0 || i >= flowerbed.length) {
            return true;
        }
        
        return flowerbed[i] == 0;
    }
}