public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for(int i = 0; i < m; i++){
            if(flowerbed[i] == 1 || (i > 0 && flowerbed[i - 1] == 1) || (i < m - 1 && flowerbed[i + 1] == 1)) continue;
            n--;
            flowerbed[i] = 1;
        }
        return n <= 0;
    }
}