class Solution {
    List<Integer> list=new ArrayList<>();
    int getsum(int[] nums,int s)
    {
        int ans=0;
        for (int i=0;i<nums.length;i++)
            if ((s&(1<<i))>0) ans+=nums[i];
        return ans;
    }
    boolean dfs(int k,int s)
    {
        if (k==0) return true;
        for (int x:list)
            if (((s&x)==x) && dfs(k-1,s-x)) return true;
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0,n=nums.length;
        for (int x:nums) sum+=x;
        if (sum%k!=0) return false;
        sum/=k;
        int m=(1<<n);
        for (int i=0;i<=m;i++) 
            if (getsum(nums,i)==sum) list.add(i);
        return dfs(k,m-1);
    }
}