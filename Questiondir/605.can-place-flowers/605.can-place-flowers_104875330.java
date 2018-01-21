public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int ans = 0;
        int count = 0;

        for (int i : flowerbed) {
            if (i == 1) {
                ans += (count - 1) / 2;
                count = 0;
            } else {
                count++;
            }
        }

        ans += count / 2;

        count = 0;
        for (int i : flowerbed) {
            if (i == 0) {
                count++;
            } else {
                break;
            }
        }

        if (count > 0 && flowerbed.length > count && count % 2 == 0) {
            ans++;
        }
        if (count == flowerbed.length && count % 2 == 1) {
            ans++;
        }

        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            ans = 1;
        }

        return ans >= n;
    }
}