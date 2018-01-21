class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int sum = 0;
        for (int num : nums) sum += num;
        int left = 0;
        int right = sum - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (left == right) return i;
            left += nums[i];
            right -= nums[i+1];
        }
        if (left == right) return nums.length - 1;
        return -1;
    }
}