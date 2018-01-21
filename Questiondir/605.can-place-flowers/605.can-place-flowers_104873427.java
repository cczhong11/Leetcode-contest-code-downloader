public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last = -2;
        int max = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                int sum = i-2-(last+2)+1;
                if (sum > 0) {
                    //System.out.println("sum: "+sum+" i: "+i+" last: "+last+" max: "+max);
                    if (sum % 2 == 0) max += sum/2;
                    else max += sum/2+1;
                }
                last = i;
            }
        }
        int sum = flowerbed.length-1-(last+2)+1;
        if (sum > 0) {
            //System.out.println("sum: "+sum+" last: "+last+" max: "+max);
            if (sum % 2 == 0) max += sum/2;
            else max += sum/2+1;
        }
        System.out.println("max: "+max);
        return n <= max;
    }
}