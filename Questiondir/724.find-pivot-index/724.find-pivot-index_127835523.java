import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        {
            System.out.println(sol.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
            System.out.println(sol.pivotIndex(new int[]{1, 2, 3}));

        }
    }


    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] s = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            s[i] = nums[i] + (i - 1 >= 0 ? s[i - 1] : 0);

        for (int i = 0; i < nums.length; i++) {
            int left = i - 1 >= 0 ? s[i - 1] : 0;
            int right = s[nums.length - 1] - s[i];
            if (left == right) return i;
        }
        return -1;

    }


}
