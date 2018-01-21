import java.util.*;
import java.util.stream.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(sol.judgePoint24(new int[]{1, 2, 1, 2}));
    }

    private boolean dfs(double[] nums) {
//        System.out.println(Arrays.toString(nums));

        if (nums.length == 1) {
            return Math.abs(nums[0] - 24) < 1e-8;
        }

        double[] a = new double[nums.length - 1];

        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (i != j) {
                    int len = 0;
                    for (int k = 0; k < nums.length; k++) {
                        if (k != i && k != j) {
                            a[len++] = nums[k];
                        }
                    }

                    a[len] = nums[i] + nums[j];
                    if (dfs(a)) return true;

                    a[len] = nums[i] - nums[j];
                    if (dfs(a)) return true;

                    a[len] = nums[i] * nums[j];
                    if (dfs(a)) return true;

                    if (Math.abs(nums[j]) > 1e-8) {
                        a[len] = nums[i] / nums[j];
                        if (dfs(a)) return true;
                    }
                }
        return false;

    }


    public boolean judgePoint24(int[] nums) {
        return dfs(IntStream.of(nums).mapToDouble(i -> i).toArray());
    }
}


