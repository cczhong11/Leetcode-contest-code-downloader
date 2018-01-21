public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int x = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) continue;
            if ((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                x++;
                flowerbed[i] = 1;
            }
        }
        return x >= n;
    }
}