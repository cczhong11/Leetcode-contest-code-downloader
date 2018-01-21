public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (i > 0 && flowerbed[i - 1] == 1) {
                i++;
                continue;
            }
            if (flowerbed[i] == 0) {
                if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                    i++;
                    continue;
                }
                count++;
            }
            i += 2;
            if (count >= n) {
                return true;
            }
        }
        return count >= n;
    }
}