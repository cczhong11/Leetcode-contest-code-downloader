class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        if (n==0) return true;
        boolean[][] bo=new boolean[n][n+1];
        for (int i=0;i<n;i++) bo[i][0]=true;
        for (int i=0;i<n;i++) bo[i][1]=(s.charAt(i)=='*');
        for (int len=2;len<=n;len++)
            for (int i=0;i<n;i++)
            {
                int j=i+len-1;
                if (j>=n) continue;
                if (s.charAt(i)=='(' && s.charAt(j)==')') bo[i][len]=bo[i+1][len-2];
                if (s.charAt(i)=='*' && s.charAt(j)==')') bo[i][len]=bo[i+1][len-2];
                if (s.charAt(i)=='*' && s.charAt(j)=='*') bo[i][len]=bo[i+1][len-2];
                if (s.charAt(i)=='(' && s.charAt(j)=='*') bo[i][len]=bo[i+1][len-2];
                for (int k=i+1;k<=j;k++)
                    if (bo[i][k-i] && bo[k][len-(k-i)]) bo[i][len]=true;
            }
        return bo[0][n];
    }
}