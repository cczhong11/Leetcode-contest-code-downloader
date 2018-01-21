public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if (n==0) {
            return true;
        }
        int firstEmpty = -1;
        int count = 0;
        for(int a: flowerbed) {
            if (a == 0) {
                firstEmpty = count;
                break;
            }
            count++;
        }
        if (firstEmpty == -1) {
            return false;
        }
        
        if(firstEmpty >0 && flowerbed[firstEmpty-1] == 1) {
            firstEmpty++;
        }
        
        int flowersToPlace = n;
        for(int a= firstEmpty; a<flowerbed.length; a+=2) {
            if (a+1 < flowerbed.length && flowerbed[a+1] ==1) {
                a++;
                continue;
            }
            if (flowerbed[a] == 0) {
                flowersToPlace--;
            } else if (flowerbed[a] == 1){
                continue;
            } else {
                a+=1;
            }
        }
        
        return flowersToPlace <= 0;
    }
}