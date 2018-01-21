import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int maximumProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] neg = IntStream.of(nums).filter(i -> i < 0).sorted().toArray();
        int[] zero = IntStream.of(nums).filter(i -> i == 0).sorted().toArray();
        int[] pos = IntStream.of(nums).filter(i -> i > 0).sorted().toArray();

        if (zero.length > 0) ans = 0;
        if (pos.length >= 3) {
            int n = pos.length;
            ans = Math.max(ans, pos[n - 1] * pos[n - 2] * pos[n - 3]);
        }
        if (pos.length >= 2 && neg.length >= 1) {
            ans = Math.max(ans, pos[0] * pos[1] * neg[neg.length - 1]);
        }
        if (pos.length >= 1 && neg.length >= 2) {
            ans = Math.max(ans, pos[pos.length - 1] * neg[0] * neg[1]);
        }
        if (neg.length >= 3) {
            int n = neg.length;
            ans = Math.max(ans, neg[n - 1] * neg[n - 2] * neg[n - 3]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumProduct(new int[]{1, 2, 3, 4}));

    }
}