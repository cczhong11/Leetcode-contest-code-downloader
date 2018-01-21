public class Solution {
    public int findIntegers(int num) {
        if (num < 0) return 0;
        if (num <= 2) return num + 1;
        
        int R = 32;
        int[] bits = new int[R];
        
        // the highest 1 bit
        int hi = 0; 
        for (int i = 0; i < R; i++) {
            if (((num >>> i) & 1) == 1) {
                bits[i] = 1;
                hi = i;
            }
        }
        
        // number of choices
        int[] nc = new int[hi+1];
        nc[0] = 1;
        nc[1] = 2;
        for (int i = 2; i <= hi; i++) {
            nc[i] = nc[i-1] + nc[i-2];
        }
        
        int cnt = 0;
        for (int i = hi;  i >= 0; i--) {
            // choose 0
            if (bits[i] == 1) {
                cnt += nc[i]; 
                i--;
                if (i >= 0 && bits[i] == 1) {
                    cnt += nc[i];
                    return cnt;
                }
            } 
        }
        return cnt + 1;
    }
}