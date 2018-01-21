class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0)
            return 0;
        
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i=0; i<n; i++){
            f[i] = 1;
            g[i] = 1;
        }
        
        int maxLength = 0;
        for (int i=0;i<n;i++){
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i] && f[j]+1 > f[i]){
                    f[i] = f[j] + 1;
                    g[i] = g[j];
                }
                else if (nums[j] < nums[i] && f[j]+1==f[i]){
                    g[i] += g[j];
                }
            }
            maxLength = Math.max(maxLength, f[i]);
        }
        //System.out.println(maxLength);
        
        int res = 0;
        for (int i=0; i<n; i++)
            if (f[i]==maxLength)
                res+=g[i];
        return res;
    }
}