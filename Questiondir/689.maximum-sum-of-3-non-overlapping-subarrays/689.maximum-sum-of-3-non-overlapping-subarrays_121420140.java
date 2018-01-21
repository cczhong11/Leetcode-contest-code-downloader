class Solution {
    
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int [n+1];
        sum[0] = 0;
        for (int i=1; i<=n; i++)
            sum[i] = sum[i-1] + nums[i-1];
        
        for (int i=n; i>=k; i--)
            sum[i] -= sum[i-k];
        
        int[] maxPre = new int[n+1];
        int[] maxPos = new int[n+1];
        
        maxPre[k] = k;
        for (int i=k+1; i<=n; i++)
            if (sum[i]>sum[maxPre[i-1]])
                maxPre[i] = i;
            else
                maxPre[i] = maxPre[i-1];
        
        maxPos[n] = n;
        for (int i=n-1;i>=k;i--)
            if (sum[i] >= sum[maxPos[i+1]])
                maxPos[i] = i;
            else
                maxPos[i] = maxPos[i+1];
        
        int[] res = new int[3];
        res[0] = -1;
        
        for (int i=2*k; i+k<=n; i++){
            if (res[0]==-1 || 
                sum[i] + sum[maxPre[i-k]] + sum[maxPos[i+k]] > sum[res[0]] + sum[res[1]] + sum[res[2]] ||
                (sum[i] + sum[maxPre[i-k]] + sum[maxPos[i+k]] == sum[res[0]] + sum[res[1]] + sum[res[2]] && 
                 prior(maxPre[i-k],  i, maxPos[i+k], res[0], res[1], res[2]))){
                
                
                res[0] = maxPre[i-k];
                res[1] = i;
                res[2] = maxPos[i+k];
                
            }
        }
        
        for (int i=0;i<3;i++)
            res[i] -= k;
        
        return res;
    }
    
    private boolean prior(int a1, int a2, int a3, int b1, int b2, int b3){
        if (a1<b1) return true;
        if (a1>b1) return false;
        if (a2<b2) return true;
        if (a2>b2) return false;
        return a3<b3;
    }
}