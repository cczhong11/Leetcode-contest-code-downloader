class Solution {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length,t=0,x=0;
        for (int i=1;i<n;i++)
            if (nums[i-1]>nums[i]) 
            {
                t++;
                x=i;
            }
        if (t>1) return false;
        if (t==0) return true;
        if (x==1) return true;
        if (x==n-1) return true;
        return (nums[x-2]<=nums[x] || nums[x-1]<=nums[x+1]);
    }
}