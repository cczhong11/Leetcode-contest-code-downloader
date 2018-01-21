public class Solution {
    public int findIntegers(int num) {
        int[] arr1 = new int[33];
        arr1[0] = 1;
        arr1[1] = 1;
        for (int i = 2; i < 33; i++) {
            arr1[i] = arr1[i - 1] + arr1[i - 2];
        }
        
        int[] arr2 = new int[33];
        arr2[0] = 1;
        arr2[1] = 2;
        for (int i = 2; i < 33; i++) {
            arr2[i] = arr2[i - 1] + arr2[i - 2];
        }
        
        
        int k = 0;
        int v = 1;
        while (v * 2 <= num) {
            v *= 2;
            k++;
        }
        
        int res = 0;
        while (num > 0) {
            res += arr2[k];
            k--;
            num -= v;
            v /= 2;
            
            if (num == 0) return res + 1;
            if (num >= v) {
                res += arr2[k];
                return res;
            } else {
                while (v > num) {
                    k--;
                    v /= 2;
                }
            }
        }
        return res;
     }
}