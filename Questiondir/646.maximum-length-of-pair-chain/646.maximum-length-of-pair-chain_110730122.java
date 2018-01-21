public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n=pairs.length;
        int[] f=new int[n+1];
        //f[0]=Integer.
        //f[0]=0;
        for (int i=0;i<n;i++)
        {
            f[i]=1;
            for (int j=0;j<i;j++)
                if (pairs[j][1]<pairs[i][0]) f[i]=Math.max(f[i],f[j]+1);
        }
        return f[n-1];
    }
}