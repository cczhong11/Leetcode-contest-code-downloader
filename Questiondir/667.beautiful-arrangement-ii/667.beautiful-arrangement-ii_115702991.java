class Solution {
    public int[] constructArray(int n, int k) {
        int f[]=new int[n];
        f[0]=1;
        int x=k,y=1;
        for (int i=1;i<=k;i++)
        {
            f[i]=f[i-1]+x*y;
            x--;
            y=-y;
        }
        for (int i=k+1;i<n;i++) f[i]=i+1;
        return f;
    }
}