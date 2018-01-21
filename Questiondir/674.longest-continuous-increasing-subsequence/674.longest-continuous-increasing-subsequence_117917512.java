class Solution {
    public int findLengthOfLCIS(int[] nums) {
         int n = nums.length;
        if (n==0)
            return 0;
        
        int[] f = new int[n];
        for (int i=0; i<n; i++){
            f[i] = 1;
        }
        
        int maxLength = 0;
        for (int i=0;i<n;i++){
            if (i > 0 && nums[i-1] < nums[i])
                f[i] = f[i-1]+1;
            else
                f[i] = 1;
            maxLength = Math.max(maxLength, f[i]);
        }
        
        return maxLength;
    }
}