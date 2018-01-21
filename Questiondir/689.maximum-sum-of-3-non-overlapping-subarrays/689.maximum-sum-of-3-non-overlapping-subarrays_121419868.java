class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        int n = nums.length;
        if (n == 0) return res;
        int[] S = new int[nums.length - k + 1];
        S[0] = 0;
        for (int i = 0; i < k; i++) S[0] += nums[i];
        for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        n = S.length;
        
        int[] max = new int[n];
        int[] index = new int[n];
        max[n - 1] = S[n - 1];
        index[n - 1] = n - 1;
        for (int i = n - 2; i >= 2 * k; i--) {
            if (S[i] >= max[i + 1]) {
                max[i] = S[i];
                index[i] = i;
            }
            else {
                max[i] = max[i + 1];
                index[i] = index[i + 1];
            }
        }
        
        int[] pairmax = new int[n];
        int[] pairindex = new int[n];
        pairmax[n - k - 1] = S[n - k - 1] + S[n - 1];
        pairindex[n - k - 1] = n - k - 1;
        for (int i = n - k - 2; i >= k; i--) {
            if (S[i] + max[i + k] >= pairmax[i + 1]) {
                pairmax[i] = S[i] + max[i + k];
                pairindex[i] = i;
            }
            else {
                pairmax[i] = pairmax[i + 1];
                pairindex[i] = pairindex[i + 1];
            }
        }
        
        int[] trimax = new int[n];
        int[] triindex = new int[n];
        trimax[n - 2 * k - 1] = S[n - 2 * k - 1] + S[n - k - 1] + S[n - 1];
        triindex[n - 2 * k - 1] = n - 2 * k - 1;
        for (int i = n - 2 * k - 2; i >= 0; i--) {
            if (S[i] + pairmax[i + k] >= trimax[i + 1]) {
                trimax[i] = S[i] + pairmax[i + k];
                triindex[i] = i;
            }
            else {
                trimax[i] = trimax[i + 1];
                triindex[i] = triindex[i + 1];
            }
        }
        
        res[0] = triindex[0];
        res[1] = pairindex[res[0] + k];
        res[2] = index[res[1] + k];
            
        return res;
    }
}