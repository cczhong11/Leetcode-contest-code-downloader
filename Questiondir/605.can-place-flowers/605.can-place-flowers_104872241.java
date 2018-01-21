public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                if (count == i) {
                    total += count / 2;
                } else {
                    total += (count - 1) / 2;
                }
                if (total >= n) return true;
                count = 0;
            }
        }
        if (count > 0) {
            if (count == flowerbed.length) {
                total += (count + 1) / 2;
            } else {
                total += count / 2;
            }
        }
        return total >= n;
    }
}