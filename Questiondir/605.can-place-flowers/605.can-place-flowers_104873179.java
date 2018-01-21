public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int left = 0;
        int places = 0;
        for(int i = 0; i < flowerbed.length; ) {
            if(flowerbed[i] == 1) {
                left = 1;
                ++ i;
            }
            else {
                int j = i+1;
                for(; j < flowerbed.length && flowerbed[j] == 0; ++j)
                    ;
                int right = j < flowerbed.length ? 1 : 0;
                int count = j - i;
                if(left == 0 && right == 0) {
                    places += (count + 1) / 2;
                }
                else if(left == 0 || right == 0) {
                    places += count / 2;
                }
                else {
                    places += (count - 1) / 2;
                }
                i = j;
            }
        }
        return places >= n;
    }
}