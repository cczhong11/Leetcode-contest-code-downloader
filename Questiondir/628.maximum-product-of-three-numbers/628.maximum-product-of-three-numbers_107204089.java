import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 3) {
        	return nums[0] * nums[1] * nums[2];
        }
        int res = 0;
        int n = nums.length;
        res = Math.max(res, nums[n - 1] * nums[n - 2] * nums[n - 3]);
        res = Math.max(res, nums[n - 1] * nums[1] * nums[0]);
        if (res < 0) {
        	for (int i = 0; i < n; ++i) if (nums[i] == 0) res = 0;
        }
        return res;
    }
}