import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(sol.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(sol.findLengthOfLCIS(new int[]{3}));


    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ) {
            int j;
            for (j = i + 1; j < nums.length && nums[j] > nums[j - 1]; j++) ;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }
}