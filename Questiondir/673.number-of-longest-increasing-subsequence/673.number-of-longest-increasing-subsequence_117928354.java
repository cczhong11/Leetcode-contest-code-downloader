class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2]; // 0 length, 1 count
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i = 1; i < n; i++) {
            int length = 1;
            int count = 1;
            for(int j = 0; j < i ; j++) {
                int l = dp[j][0];
                if(nums[i] > nums[j]) {
                    if(l + 1 > length) {
                        length = l + 1;
                        count = dp[j][1];
                    }else if(l + 1 == length) {
                        count += dp[j][1];
                    }
                }
            }
            dp[i][0] = length;
            dp[i][1] = count;
            // for(int[] d : dp) {
            //     System.out.print(d[0] + "," + d[1] + " ");
            // }
            // System.out.println();
        }
        
        int length = 0;
        int count = 0;
        for(int[] d : dp) {
            // System.out.println(d[0] + " " + length);
            if(d[0] > length) {
                count = d[1];
                length = d[0];
            } else if (d[0] == length) {
                count += d[1];
            }
        }
        return count;
    }
}