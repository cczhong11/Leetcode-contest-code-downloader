class Solution {
    public int[] maxSumOfThreeSubarrays(int[] a, int k) {
        int n = a.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] S = new int[n];
        int[] sum = new int[n];
        // calc S
        for (int i = 0; i < n; i++) {
            S[i] = a[i] + (i > 0 ? S[i-1]: 0);
            
        }
        for (int i = 0; i <= n-k; i++) {
            sum[i] = S[i+k-1] - (i > 0 ? S[i-1]: 0);
            //System.out.format("%d\n", sum[i]);
        }
        
        int max_sum = -1;
        int l = -1;
        for (int i = 0; i <= n-k; i++) {
            if (sum[i] > max_sum) {
                max_sum = sum[i];
                l = i;
            }
            L[i] = l;
        } 
    
        max_sum = -1;
        int r = -1;
        for (int i = n-k; i >= 0; i--) {
            if (sum[i] > max_sum) {
                max_sum = sum[i];
                r = i;
            }
            R[i] = r;
        }
        
            
        int[] result = {-1,-1,-1};
        int max_3sum = -1;
        for (int j = k; j <= n-k-k; j++) {
            int curr_3sum = sum[L[j-k]] + sum[j] + sum[R[j+k]];
            if (curr_3sum > max_3sum) {
                max_3sum = curr_3sum;
                result = new int[]{L[j-k], j, R[j+k]};
            }
        }
        return result;
    }
}