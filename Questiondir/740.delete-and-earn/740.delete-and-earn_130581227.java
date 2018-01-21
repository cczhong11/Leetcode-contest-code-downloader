import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(sol.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(sol.deleteAndEarn(new int[]{3, 3, 3, 4, 2}));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<Integer> a = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int j = i;
            for (j = i + 1; j < nums.length && nums[i] == nums[j]; j++) ;
            a.add(nums[i]);
            cnt.add(j - i);
            i = j;
        }

        int[] f = new int[a.size()];
        int ans = 0;
        for (int i = 0; i < f.length; i++) {
            f[i] = i - 1 >= 0 ? f[i - 1] : 0;
            if (i - 1 >= 0 && a.get(i) - 1 == a.get(i - 1)) {
                f[i] = Math.max(f[i], a.get(i) * cnt.get(i) + (i - 2 >= 0 ? f[i - 2] : 0));
            } else {
                f[i] = Math.max(f[i], a.get(i) * cnt.get(i) + (i - 1 >= 0 ? f[i - 1] : 0));
            }
            ans = Math.max(ans, f[i]);
        }
//        System.out.println(a);
//        System.out.println(cnt);
//        System.out.println(Arrays.toString(f));
        return ans;
    }
}