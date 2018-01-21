public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(prev == 0 && ((i+1) == flowerbed.length || flowerbed[i+1] == 0) && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
            prev = flowerbed[i];
        }
        if(n <= 0)
            return true;
        return false;
    }
}