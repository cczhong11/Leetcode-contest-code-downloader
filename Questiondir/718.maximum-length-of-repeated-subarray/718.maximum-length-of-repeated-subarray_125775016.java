class Solution {
    public int findLength(int[] A, int[] B) {
        int n=A.length,m=B.length;
        int f[][]=new int[n+1][m+1];
        int ans=0;
        for (int i=1;i<=n;i++)
            for (int j=1;j<=m;j++)
                if (A[i-1]==B[j-1]) 
                {
                    f[i][j]=f[i-1][j-1]+1;
                    ans=Math.max(ans,f[i][j]);
                }
        return ans;
    }
}