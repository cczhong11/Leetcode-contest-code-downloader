public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                boolean bad = false;
                if(i > 0 && flowerbed[i - 1] == 1) bad = true;
                if(i < flowerbed.length - 1 && flowerbed[i+1] == 1) bad = true;
                if(!bad) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}