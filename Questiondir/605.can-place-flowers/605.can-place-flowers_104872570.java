public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ptr = 0;
        while (ptr < flowerbed.length && n > 0) {
            int cur = flowerbed[ptr];
            if (cur == 0) {
                int pre = ptr - 1 >= 0 ? flowerbed[ptr - 1] : 0;
                int nxt = ptr + 1 < flowerbed.length ? flowerbed[ptr + 1] : 0;
                if (pre == 0 && nxt == 0) {
                    flowerbed[ptr] = 1;
                    n--;
                }
            }
            ptr++;
        }
        
        return n == 0;
    }
}