class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        if (n==0)
            return true;
        
        boolean[][] f = new boolean[n][n];
        for (int i=1; i<n; i++)
            f[i][i-1] = true;
        for (int i=0; i<n; i++)
            f[i][i] = s.charAt(i) == '*';
        
        for (int k=1;k<n;k++){
            for (int i=0; i+k<n; i++){
                if ((s.charAt(i)=='(' || s.charAt(i)=='*') && (s.charAt(i+k)==')' || s.charAt(i+k)=='*'))
                    f[i][i+k] = f[i][i+k] || f[i+1][i+k-1];
                
                if (!f[i][i+k]){
                    for (int j=0;j<=k;j++){
                        f[i][i+k] = f[i][i+j] && ((j==k) ? true : f[i+j+1][i+k]);
                        if (f[i][i+k])
                            break;
                    }
                }
            }
        }
        
        
        return f[0][n-1];
    }
}