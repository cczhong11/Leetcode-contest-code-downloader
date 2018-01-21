class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }

        if (k == 1) {
            return true;
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int subset = sum / k;
        int N = nums.length;
        int used = 0;
        boolean[] visited = new boolean[1 << N];
        boolean[] isValid = new boolean[1 << N];
        return helper_mem(nums, 0, 0, k, subset, used, visited, isValid);
    }
    
    public boolean helper_mem(int[] input, int curSum, int curK, int k, int subset, int used, boolean[] visited,
            boolean[] isValid) {
        if (curK == k) {
            visited[used] = true;
            isValid[used] = true;
            return true;
        }

        if (visited[used]) {
            return isValid[used];
        }
        int N = input.length;

        for (int i = 0; i < N; i++) {
            int cur = 1 << i;
            if ((used & cur) != 0 || curSum + input[i] > subset) {
                continue;
            }
            if (curSum + input[i] == subset) {
                if (helper_mem(input, 0, curK + 1, k, subset, used | cur, visited, isValid)) {
                    visited[used] = true;
                    isValid[used] = true;
                    return true;
                }
            } else if (curSum + input[i] < subset) {
                if (helper_mem(input, curSum + input[i], curK, k, subset, used | cur, visited, isValid)) {
                    visited[used] = true;
                    isValid[used] = true;
                    return true;
                }
            }
        }
        visited[used] = true;
        isValid[used] = false;
        return false;
    }
}