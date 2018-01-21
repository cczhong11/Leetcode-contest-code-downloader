class Solution {
    int ans=0;
    int[][] tree=new int[10][40];
    boolean[][] bo=new boolean[10][40];
    void dfs(int d,int p,int sum)
    {
        if (!bo[d][p]) return;
        if (!bo[d+1][p<<1] && !bo[d+1][p*2+1]) ans+=sum+tree[d][p];
        dfs(d+1,p<<1,sum+tree[d][p]);
        dfs(d+1,p*2+1,sum+tree[d][p]);
    }
    public int pathSum(int[] nums) {
        int n=nums.length;
        for (int x:nums)
        {
            int d=x/100,p=(x%100)/10-1,v=x%10;
            tree[d][p]=v;
            bo[d][p]=true;
        }
        dfs(1,0,0);
        return ans;
    }
}