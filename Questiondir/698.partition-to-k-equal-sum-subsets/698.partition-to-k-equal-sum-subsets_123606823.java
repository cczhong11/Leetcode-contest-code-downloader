class Solution {
    
    int[] nums;
    boolean[] f;
    int k;
    int tar;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        if (k <= 1) return true;
        int n = nums.length;
        
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
            sum += num;
        }
        
        if (sum % k != 0 ) return false;
        if (max > sum / k) return false;
        
        this.nums = nums;
        this.k = k;
        
        this.tar = sum / k;
        f = new boolean[n];

        f[0] = true;
        return dfs(1,nums[0]);
    }
    
    boolean dfs(int s, int cur) {
    
        if (cur == tar) {
            for (int i = 0 ; i < nums.length; i++) {
                if (!f[i]) {
                    f[i] = true;
                    boolean t = dfs(i + 1, nums[i]);
                    f[i] = false;
                    return t;
                }
            }
            return true;
        }
        
        for (int i = s; i < nums.length ; i++) {
            if (!f[i] && nums[i] + cur <= tar) {
                f[i] = true;
                boolean t = dfs(i + 1, cur + nums[i]);
                f[i] = false;
                if (t) return true;
            }
        }
        
        return false;
    }
    
}