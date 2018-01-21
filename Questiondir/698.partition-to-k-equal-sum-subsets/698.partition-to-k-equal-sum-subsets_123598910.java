class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] targets = new int[k];
        Arrays.fill(targets, sum / k);
        return backtrack(targets, k, nums, nums.length - 1);
    }
    
    private boolean backtrack(int[] targets, int k, int[] nums, int index) {
        if (index == -1) {
            for (int j = 0; j < k; j++) {
                if (targets[j] != 0) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (targets[i] < nums[index]) continue;
            targets[i] -= nums[index];
            if (backtrack(targets, k, nums, index - 1)) {
                return true;
            }
            targets[i] += nums[index];
        }
        return false;
    }
}