public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                else return a[0]-b[0];
            }
        });
        int[] dp =  new int[pairs.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=1;i<pairs.length;i++){
            for(int j=i-1;j>=0;j--){
                if(pairs[i][0]>pairs[j][1]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}