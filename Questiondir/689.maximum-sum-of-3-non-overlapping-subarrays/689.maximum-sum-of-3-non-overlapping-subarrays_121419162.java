class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int sum[] = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        int dpa[] = new int[len+1];
        int suma[] = new int[len+1];
        dpa[k] = 1;
        suma[k] = sum[k];
        for (int i = k+1; i <= len; i++) {
            int a = sum[i] - sum[i-k];
            if (a > suma[i-1]) {
                dpa[i] = i-k+1;
                suma[i] = a;
            } else {
                dpa[i] = dpa[i-1];
                suma[i] = suma[i-1];
            }
        }
        
        int dpb[] = new int[len+1];
        int sumb[] = new int[len+1];
        dpb[len-k+1] = len-k+1;
        sumb[len-k+1] = sum[len] - sum[len-k];
        for (int i = len-k; i>= 1; i--) {
            int b = sum[i+k-1] - sum[i-1];
            if (b >= sumb[i+1]) {
                dpb[i] = i;
                sumb[i] = b;
            } else {
                dpb[i] = dpb[i+1];
                sumb[i] = sumb[i+1];
            }
        }
        
        int res[] = new int[3];
        int maxv = 0;
        for (int i = k+1; i+k-1+k<=len; i++) {
            int val = suma[i-1] + sum[i+k-1]-sum[i-1] + sumb[i+k];
            if (val > maxv) {
                maxv = val;
                res[0] = dpa[i-1]-1;
                res[1] = i-1;
                res[2] = dpb[i+k]-1;
            }
        }
        return res;
    }
}