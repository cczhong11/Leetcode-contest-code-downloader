class Solution {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length,max=0;
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> left=new HashMap<>();
        Map<Integer,Integer> right=new HashMap<>();
        for (int x:nums) map.put(x,map.getOrDefault(x,0)+1);
        for (int x:nums) max=Math.max(map.get(x),max);
        for (int i=0;i<n;i++)
        {
            int x=nums[i];
            if (map.get(x)==max)
            {
                left.put(x,Math.min(i,left.getOrDefault(x,n+1)));
                right.put(x,Math.max(i,left.getOrDefault(x,-1)));
            }
        }
        int ans=n;
        for (int i=0;i<n;i++)
        {
            int x=nums[i];
            if (map.get(x)==max)
            {
                ans=Math.min(ans,right.get(x)-left.get(x)+1);
            }
        }
        return ans;
    }
}