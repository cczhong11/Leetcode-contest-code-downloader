public class Solution {
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i=0;i<flowerbed.length;i++) {
            if (flowerbed[i] == 1) continue;
            int prev = i == 0 ? 0 : flowerbed[i-1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
            if (prev == -next) { 
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
    
}