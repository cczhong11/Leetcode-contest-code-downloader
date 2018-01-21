class Solution {
    int[] button1={0,1,3,7,15,31,63};
    int[] button2={0,0,2,2,10,10,42};
    int[] button3={0,1,1,5,5,21,21};
    int[] button4={0,1,1,1,9,9,9};
    public int flipLights(int n, int m) {
        if (n>6) n=6;
        boolean[][] f=new boolean[m+1][1<<n];
        f[0][0]=true;
        for (int i=0;i<=m-1;i++)
            for (int j=0;j<(1<<n);j++)
            if (f[i][j])
            {
                f[i+1][j^button1[n]]=true;
                f[i+1][j^button2[n]]=true;
                f[i+1][j^button3[n]]=true;
                f[i+1][j^button4[n]]=true;
            }
        int ans=0;
        for (int j=0;j<(1<<n);j++)
            if (f[m][j]) ans++;
        return ans;
    }
}