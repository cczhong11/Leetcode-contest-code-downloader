class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        // TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        // map.put(1, nums.length);
        int max = 1;
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int num = dp[j] + 1;
                    if (num > dp[i]) {
                        dp[i] = num;
                        count[i] = count[j];
                    } else if (num == dp[i]) {
                        count[i] += count[j];
                    }
                    // map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
        // return map.lastEntry().getValue();
    }
}