public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length];
        for(int i=0; i<nums.length; ++i)
            ++cnt[nums[i]-1];
        int[] ans = new int[2];
        for(int i=0; i<nums.length; ++i)
            if(cnt[i]==2)
                ans[0]=i+1;
            else if(cnt[i]==0)
                ans[1]=i+1;
        return ans;
    }
}