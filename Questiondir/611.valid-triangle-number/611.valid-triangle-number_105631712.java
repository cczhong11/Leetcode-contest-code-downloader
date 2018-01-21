import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        for (int k = 0; k < nums.length; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    cnt += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int[] a = {2, 2, 3, 4};
        int[] a = {5, 5, 5, 5, 5};
        Solution sol = new Solution();
        System.out.println(sol.triangleNumber(a));
    }
}