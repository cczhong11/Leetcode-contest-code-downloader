public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1) continue;
            else {
                if ((i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));

    }
}