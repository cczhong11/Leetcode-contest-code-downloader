import java.util.Arrays;

public class Solution {
    private boolean can(long[] sum, int k, double avg) {
        double[] p = new double[sum.length];
        for (int i = 0; i < sum.length; i++) {
            p[i] = sum[i] - i * avg;
        }
        double curMin = Double.POSITIVE_INFINITY;
        for (int i = 0; i < sum.length; i++) {
            if (i >= k) {
                curMin = Math.min(curMin, p[i - k]);
                if (p[i] >= curMin) {
                    return true;
                }
            }
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double left = Arrays.stream(nums).min().getAsInt();
        double right = Arrays.stream(nums).max().getAsInt();
        while (right - left > 1e-6) {
            double mid = (left + right) * 0.5;
            if (can(sum, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}