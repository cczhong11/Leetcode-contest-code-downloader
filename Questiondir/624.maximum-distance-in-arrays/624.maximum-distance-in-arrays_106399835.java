public class Solution {
    public int maxDistance(int[][] arrays) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        int res = 0;
        int m = arrays.length;
        for (int i = 0; i < m; i++) {
            if (arrays[i].length > 0 && arrays[i][0] < m2) {
                m2 = arrays[i][0];
                p2 = i;
                
                if (m2 < m1) {
                    int tmp = m2;
                    m2 = m1;
                    m1 = tmp;
                    tmp = p2;
                    p2 = p1;
                    p1 = tmp;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            int n = arrays[i].length;
            if (n == 0) continue;
            if (i != p1) {
                res = Math.max(res, arrays[i][n - 1] - m1);
            } else {
                res = Math.max(res, arrays[i][n - 1] - m2);
            }
        }
        
        return res;
    }
}