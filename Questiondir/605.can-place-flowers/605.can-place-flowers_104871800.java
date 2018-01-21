public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0 ; i < flowerbed.length ; i++ ) {
            if((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) && flowerbed[i] == 0) {
                System.out.println(i);
                n--;
                flowerbed[i] = 1;
            }
            if(n <= 0)  return true;
        }
        return false;
    }
}