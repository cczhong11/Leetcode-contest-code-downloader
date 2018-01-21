import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int dominantIndex(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > nums[idx])
                idx = i;
        for (int i = 0; i < nums.length; i++)
            if (i != idx && 2 * nums[i] > nums[idx]) return -1;
        return idx;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(sol.dominantIndex(new int[]{1, 2, 3, 4}));

    }
}

