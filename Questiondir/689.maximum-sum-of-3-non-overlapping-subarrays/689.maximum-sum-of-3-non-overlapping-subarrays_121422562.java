class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, max = -1;
        int[] sums = new int[n-k+1], res = new int[3];
        int sum = 0;
        for (int i=0;i<k;i++){
            sums[0]+=nums[i];
        }
        for (int i=1;i<=n-k;i++){
            sums[i] = sums[i-1]-nums[i-1]+nums[i+k-1];
        }
        for (int i=k;i<=n-2*k;i++){
            int j0 = 0;
            for (int j=1;j<=i-k;j++){
                if (sums[j]>sums[j0]) j0 = j;
            }
            int j1 = i+k;
            for (int j=i+k+1;j<=n-k;j++){
                if (sums[j]>sums[j1]) j1 = j;
            }
            int cur = sums[i] + sums[j0] + sums[j1];
            if (cur>max){
                max = cur;
                res[0] = j0;
                res[1] = i;
                res[2] = j1;
            }
        }
        return res;
    }
}