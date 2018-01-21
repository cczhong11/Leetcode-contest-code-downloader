public class Solution {
    public int maxA(int N) {
        int[] f=new int[Math.max(4,N+1)];
        f[0]=0;
        f[1]=1;
        f[2]=2;
        f[3]=3;
        for (int i=4;i<=N;i++)
        {
            f[i]=f[i-1]+1;
            for (int j=3;j<i;j++) f[i]=Math.max(f[i],f[i-j]*(j-1));
        }
        return f[N];
    }
}