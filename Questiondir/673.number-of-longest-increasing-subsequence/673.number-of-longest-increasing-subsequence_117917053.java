import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(sol.findNumberOfLIS(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sol.findNumberOfLIS(new int[]{1, 2, 3, 1, 2, 3}));
        System.out.println(sol.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));

    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i]) {
                    if (f[j] + 1 > f[i]) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    } else if (f[j] + 1 == f[i]) {
                        g[i] += g[j];
                    }
                }
            maxLen = Math.max(maxLen, f[i]);
        }

//        System.out.println("maxLen = " + maxLen);
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (f[i] == maxLen) {
                cnt += g[i];
            }
        return cnt;
    }
}