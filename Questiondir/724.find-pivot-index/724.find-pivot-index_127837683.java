class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int left_sum = 0, right_sum = 0;
        for (int num: nums) right_sum += num;
        right_sum -= nums[0];
        if (left_sum == right_sum) return 0;
        for (int i = 0; i < nums.length; i++){
            left_sum += nums[i];
            if (i < nums.length - 1) right_sum -= nums[i + 1];
            else break;
            if (left_sum == right_sum) return i + 1;
        }
        return -1;
    }
}