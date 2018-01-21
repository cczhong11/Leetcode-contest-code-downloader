class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count=new int[20000];
        int[][] f=new int[20000][2];
        for (int x:nums) count[x]++;
        for (int i=1;i<=10000;i++)
        {
            f[i][0]=Math.max(f[i-1][0],f[i-1][1]);
            f[i][1]=f[i-1][0]+count[i]*i;
        }
        return Math.max(f[10000][0],f[10000][1]);
    }
}