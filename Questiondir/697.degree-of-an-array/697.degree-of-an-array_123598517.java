class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        
        int[] f = new int[50000];
        int[] l = new int[50000];
        int[] r = new int[50000];    
        
        int deg = 0;
        int ans = Integer.MAX_VALUE;

        
        for (int i = 0 ; i < n ; i++) {
            
            int num = nums[i];
            f[num]++;
            if (f[num] == 1) {
                l[num] = i;
            }
            r[num] = i;
            
            if (f[num] == deg) {
                ans = Math.min(ans, r[num] - l[num] + 1);
            }
            
            if (f[num] > deg) {
                deg = f[num];
                ans = r[num] - l[num] + 1;
            }
        }
        
        return ans;
        
    }
}