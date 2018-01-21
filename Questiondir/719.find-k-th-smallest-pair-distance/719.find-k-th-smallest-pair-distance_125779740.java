class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len=1000001;
        int[] dp=new int[len];
        for(int i=1;i<nums.length;i++)
            for(int j=0;j<i;j++)
            	if(i!=j)
            		dp[Math.abs(nums[i]-nums[j])]++;
        for(int i=0;i<len;i++){
        	// System.out.println(dp[i]);
            k-=dp[i];
            if(k<=0)return i;
        }
        return nums[nums.length-1];
    }
}