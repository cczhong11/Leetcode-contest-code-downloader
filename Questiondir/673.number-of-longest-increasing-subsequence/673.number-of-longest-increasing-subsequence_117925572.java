class Solution {
    public int findNumberOfLIS(int[] nums) {
        int size = lis(nums);
        int[][] dp = new int[nums.length + 1][size];
        for(int j = 0; j < size; ++ j) {
            for(int i = j; i < nums.length; ++ i) {
                if(j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    for (int k = 0; k < i; ++ k) {
                        if(nums[i] > nums[k]) {
                            dp[i][j] += dp[k][j - 1];
                        }
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < nums.length; ++ i) {
            sum += dp[i][size - 1];
        }
        return sum;
    }

    int lis(int[] nums) {
        int[] a = new int[nums.length];
        int size = 0;
        for(int n : nums) {
            int index = Arrays.binarySearch(a, 0, size, n);
            if(index >= 0) {
                continue;
            }
            else {
                index = - index - 1;
                a[index] = n;
                if(index == size) {
                    ++ size;
                }
            }
        }
        return size;
    }
}