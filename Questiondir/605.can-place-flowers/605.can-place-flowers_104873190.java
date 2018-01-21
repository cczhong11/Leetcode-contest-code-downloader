public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int prev = 0;
       int num = 0;
       for(int i = 0; i < flowerbed.length; i ++) {
    	   if(prev == 0 && flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
    		   num ++;
    		   prev = 1;
    	   }
    	   else prev = flowerbed[i];
    	   if(num >= n) return true;
       }
       return false;
    }
}