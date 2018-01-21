public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0 ; i < flowerbed.length; i++) {
            int left = (i == 0) ? 0 : flowerbed[i - 1];
            int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
            if (left == 0 && right == 0 && flowerbed[i] != 1) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}