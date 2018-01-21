/*class Solution {
    public int strangePrinter(String s) {
        int n=s.length();
        if (n==0) return 0;
        int[][] f=new int[n+1][n+1];
        int[] next=new int[n+1];
        for (int i=0;i<n;i++) f[i][i]=1;
        for (int i=0;i<n;i++)
        {
            next[i]=i+1;
            while (next[i]<n && s.charAt(next[i])==s.charAt(i)) next[i]++;
        }
        for (int i=n-2;i>=0;i--)
            for (int j=i+1;j<n;j++)
            {
                f[i][j]=1+f[i+1][j];
                for (int k=i+1;k<=j;k++)
                    if (s.charAt(k)==s.charAt(i))
                    {
                        int x=1+f[i+1][k-1]+f[next[k]][j];
                        f[i][j]=Math.min(f[i][j],x);
                    }
            }
        return f[1][7];
    }
}*/
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] =1;
            }
        }

        for (int l = 1; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;

                for (int k = 0; k <= i; k++) {
                    int res =1+ dp[i + 1][j][0];

                    for (int m = i + 1; m <= j; m++) {
                        if (s.charAt(m) == s.charAt(i)) {
                            res = Math.min(res, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }

                    dp[i][j][k] = res;
                }
            }
        }

        return (n == 0 ? 0 : dp[0][n - 1][0]);
    }
    
}