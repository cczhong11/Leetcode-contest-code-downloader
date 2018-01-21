class Solution {
    public String makeLargestSpecial(String S) {
        int n=S.length();
        while (true)
        {
        boolean[][] bo=new boolean[n][n];
        for (int i=0;i<n;i++)
        {
            int left=0;
            for (int j=i;j<n;j++)
            {
                if (S.charAt(j)=='1') left++; else left--;
                if (left<0) break;
                if (left==0) bo[i][j]=true;
            }
        }
        String[][] ans=new String[n][n];
        for (int i=0;i<n-1;i++) ans[i][i+1]=S.substring(i,i+2);
        for (int len=3;len<=n;len++)
            for (int i=0;i<n-len+1;i++)
            {
                int j=i+len-1;
                ans[i][j]=S.substring(i,j+1);
                String s1=ans[i][j-1]+S.charAt(j);
                String s2=S.charAt(i)+ans[i+1][j];
                if (s1.compareTo(ans[i][j])>0) ans[i][j]=s1;
                if (s2.compareTo(ans[i][j])>0) ans[i][j]=s2;
                if (bo[i][j]) 
                {
                    for (int k=i+1;k<j;k++)
                        if (bo[i][k] && bo[k+1][j])
                        {                    
                            if (ans[i][k].compareTo(ans[k+1][j])<0)
                            {
                                s1=ans[k+1][j]+ans[i][k];
                                if (s1.compareTo(ans[i][j])>0) ans[i][j]=s1;
                            }
                        }
                }
            }
        //return ans[0][n-1];
            if (ans[0][n-1].equals(S)) return S;
            S=ans[0][n-1];
        }
    }
}