public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] arr = new int[flowerbed.length + 2];
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = flowerbed[i - 1];
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == 1) {
                continue;
            } if (arr[i - 1] != 1 && arr[i + 1] != 1) {
                n--;
                arr[i] = 1;
            }
        }
        return n <= 0;
    }
}