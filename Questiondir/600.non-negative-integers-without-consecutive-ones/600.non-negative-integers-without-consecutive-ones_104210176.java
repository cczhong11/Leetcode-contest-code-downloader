public class Solution {
    public int findIntegers(int num) {
        if (num == 0) return 1;
        if (num == 1) return 2;
        
        int[] g = new int[32];
        g[1] = 1;
        g[2] = 2;
        for (int i = 3; i <= 31; ++i){
            g[i] = g[i - 1] + g[i - 2] + 1;
        }
        int[] pow = new int[32];
        pow[0] = 1;
        for (int i = 1; i <= 31; ++i) {
            pow[i] = 2 * pow[i - 1];
        }
        
        for (int i = 0; i <= 31; ++i) {
            if (num == pow[i] - 1) {
                return g[i] + 1;
            }
        }
        
        for (int i = 0; i <= 31; ++i) {
            if (num >= pow[i] && num < pow[i + 1]) {
                if (num >= pow[i] + pow[i - 1]) {
                    return g[i + 1] + 1;
                } else {
                    return g[i] + 1 + findIntegers(num - pow[i]);
                }
            }
        }
        return -1;
    }
}