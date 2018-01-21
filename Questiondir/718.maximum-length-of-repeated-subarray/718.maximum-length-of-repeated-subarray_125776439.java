import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(sol.findLength(new int[]{1, 2, 3, 2, 1, 4}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(sol.findLength(new int[]{1, 2, 3, 2, 1, 4}, new int[]{2, 3, 2, 1}));
        {

        }
    }

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ans = 0;

        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1])
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = 0;
                ans = Math.max(ans, f[i][j]);
            }

        return ans;

    }
}
