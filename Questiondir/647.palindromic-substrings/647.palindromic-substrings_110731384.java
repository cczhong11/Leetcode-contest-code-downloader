public class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean f[][]=new boolean[n+1][n+1];
        for (int i=0;i<n;i++) f[i][0]=true;
        for (int i=0;i<n;i++) f[i][1]=true;
        int ans=n;
        for (int j=2;j<=n;j++)
            for (int i=0;i<n-j+1;i++)
            {
                f[i][j]=f[i+1][j-2] && (s.charAt(i)==s.charAt(i+j-1));
                if (f[i][j]) ans++;
            }
        return ans;
    }
}