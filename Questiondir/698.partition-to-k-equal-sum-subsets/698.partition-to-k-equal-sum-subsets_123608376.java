import com.sun.media.sound.SoftTuning;

import java.util.Arrays;

class Solution {
    int[] sum;
    int n;
    int[] a;
    int total = 0;
    int partial = 0;
    Boolean[] f;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return false;
        if (k == 1) return true;

        Arrays.sort(nums);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        n = nums.length;
        a = nums;
        sum = new int[1 << n];
        for (int i = 1; i < sum.length; i++)
            for (int j = 0; j < n; j++)
                if (((1 << j) & i) != 0) {
                    sum[i] = a[j] + sum[i - (1 << j)];
                }
        total = sum[(1 << n) - 1];
        if (total % k != 0)
            return false;

        partial = total / k;
        for (int num : a)
            if (num > partial)
                return false;

        f = new Boolean[1 << n];
        return dfs((1 << n) - 1);
    }

    boolean dfs(int mask) {
//        System.out.println(Integer.toString(mask));
        if (sum[mask] == partial) return true;
        if (f[mask] != null) return f[mask];

        int[] bits = new int[Integer.bitCount(mask)];
        int len = 0;
        for (int i = 0; i < n; i++)
            if (((1 << i) & mask) != 0) {
                bits[len++] = i;
            }

        boolean ans = false;
        if (len == 1) {
            ans = sum[mask] == partial;
        } else {
            for (int i = 0; i < (1 << (len - 1)); i++) {
                int j = i * 2 + 1;
                int subMask = 0;
                for (int k = 0; k < len; k++) {
                    if (((1 << k) & j) != 0) {
                        subMask |= 1 << bits[k];
                    }
                }
                if (sum[subMask] == partial && dfs(mask - subMask)) {
                    ans = true;
                    break;
                }
            }
        }

        f[mask] = ans;
        return ans;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 3));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 5));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 2));
        System.out.println(sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 1));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 5));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 4));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1, 1}, 3));
        System.out.println(sol.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1}, 2));
    }
}