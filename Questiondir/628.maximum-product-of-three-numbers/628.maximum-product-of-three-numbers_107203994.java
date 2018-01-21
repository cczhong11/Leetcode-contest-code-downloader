public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        if(nums[1] >= 0) {
            return max;
        } else {
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1] , max );
        }
    }
}