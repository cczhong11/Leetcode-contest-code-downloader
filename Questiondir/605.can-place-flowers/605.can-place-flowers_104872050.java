public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int idx = 0;
        int cnt = 0;
        while (idx < flowerbed.length) {
            if (flowerbed[idx] == 0) {
                if (get(flowerbed, idx - 1) == 0 && get(flowerbed, idx + 1) == 0) {
                    cnt++;
                    idx += 2;
                } else {
                    idx++;
                }
            } else {
                idx += 2;
            }
        }
        return cnt >= n;
    }
    
    public int get(int[] arr, int idx) {
        if (idx < 0 || idx >= arr.length) {
            return 0;
        } else {
            return arr[idx];
        }
    }
}