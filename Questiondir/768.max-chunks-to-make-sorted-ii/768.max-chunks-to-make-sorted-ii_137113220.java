class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int max[] = new int[len];
        max[0] = arr[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(arr[i], max[i-1]);
        }
        
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            int cunMin = arr[i];
            for (int k = i; k > 0; k--) {
                cunMin = Math.min(cunMin, arr[k]);
                if (cunMin < max[k-1]) {
                    continue;
                }
                
                dp[i] = Math.max(dp[i], dp[k-1]+1);
            }
        }

        return dp[arr.length-1];
    }
}