public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len && n > 0; i ++) {
            if (flowerbed[i] == 0) {
                if ((i - 1 >= 0 && flowerbed[i - 1] == 1) 
                || (i + 1 < len && flowerbed[i + 1] == 1)) {
                    continue;
                } else {
                    flowerbed[i] = 1;
                    n --;
                }
            }
        }
        
        return n <= 0;
    }
}