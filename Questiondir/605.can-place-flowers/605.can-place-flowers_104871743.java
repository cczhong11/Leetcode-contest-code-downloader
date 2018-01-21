public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cur = 1;
        int max = 0;
        for (int i : flowerbed) {
            if (i == 0) {
                cur++;
            } else {
                max += f(cur);
                cur = 0;
            }
        }
        cur++;
        max += f(cur);
        return max >= n;
    }

    private int f(int l) {
        if (l <= 2) {
            return 0;
        }
        return (l - 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0}, 5));
    }
}