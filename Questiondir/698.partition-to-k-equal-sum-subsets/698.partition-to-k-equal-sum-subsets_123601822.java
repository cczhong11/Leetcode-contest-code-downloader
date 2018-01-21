class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum_nums = 0;
        for (int num : nums) sum_nums += num;
        if (sum_nums % k != 0) return false;
        int target = sum_nums / k;
        return new BackTrack(nums, target, k).result;
    }



    class BackTrack {
        boolean[] visited;
        int[] nums;
        int target;
        int k;
        boolean result;
        public BackTrack(int[] nums, int target, int k) {
            this.nums = nums;
            this.target = target;
            this.k = k;
            this.visited = new boolean[nums.length];
            this.result = backtrack(target, k, 0);
        }


        boolean backtrack(int target, int k, int start) {
            if (k == 1) return true;
            for (int i = start; i < nums.length; ++i) if (!visited[i] && target >= nums[i]) {
                int new_target = target - nums[i];
                visited[i] = true;
                if (new_target == 0 && backtrack(this.target, k - 1, 0)) return true;
                if (new_target > 0 && backtrack(new_target, k, i + 1)) return true;
                visited[i] = false;
            }
            return false;
        }
    }
}