public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,ans;
        if (n==3) return nums[0]*nums[1]*nums[2];
        if (nums[n-3]>=0) 
        {
            ans=nums[n-1]*nums[n-2]*nums[n-3];
            if (nums[1]<=0) ans=Math.max(ans,nums[0]*nums[1]*nums[n-1]);
        }
        else
        {
            if (nums[n-1]>=0) ans=nums[n-1]*nums[0]*nums[1];
            else ans=nums[n-1]*nums[n-2]*nums[n-3];
        }
        return ans;
    }
}