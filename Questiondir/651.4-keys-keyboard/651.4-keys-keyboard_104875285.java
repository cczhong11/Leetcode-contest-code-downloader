public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int maxAllowed = 0;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) maxAllowed++;
            return n <= maxAllowed;
        }
        int fLen = flowerbed.length;
        int[] extBed = new int[fLen + 4];
        extBed[0] = 1;
        extBed[1] = 0;
        extBed[fLen + 2] = 0;
        extBed[fLen + 3] = 1;
        for (int i = 0; i < fLen; i++) {
            extBed[i+2] = flowerbed[i];
        }
        int consZeros = 0;
        for (int i = 0; i < fLen + 4; i++) {
            if (extBed[i] == 1) {
                maxAllowed += Math.max(0, (consZeros + 1) / 2 - 1);
                consZeros = 0;
            } else {
                consZeros++;
            }
        }
        return n <= maxAllowed;
    }
}