class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) return true;
        if(nums.length < k) return false;
        int sum = 0;
        Arrays.sort(nums);
        for(int n: nums) sum += n;
        if(sum % k != 0) return false;
        int target = sum/k;
        if(nums[nums.length-1] > target) return false;
        int[] curr = new int[k];
        return solve(nums, nums.length-1, curr, target);
    }
    
    private boolean solve(int[] nums, int i, int[] curr, int target) {
        if(i == -1) return true;
        HashSet<Integer> set = new HashSet<>();
        for(int j = 0; j < curr.length; ++j) {
            if(set.add(curr[j]) && curr[j] + nums[i] <= target) {
                curr[j] += nums[i];
                if(solve(nums, i-1, curr, target)) return true;
                curr[j] -= nums[i];
            }
        }
        return false;
    }
}