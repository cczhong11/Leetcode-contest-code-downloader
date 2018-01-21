public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0 && (i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                max++;
                flowerbed[i] = 1;
            }
        }
        if(max >= n) return true;
        else return false;
    }
}