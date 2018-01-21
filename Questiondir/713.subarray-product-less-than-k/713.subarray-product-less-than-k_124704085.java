class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
                int summ=1, left=0, ans=0;
        if (k<=1)return 0;
        for (int i=0;i<nums.length;++i){
            int n=nums[i];
            summ*=n;
            if (summ>=k){
                while (summ>=k){
                   summ/=nums[left++];
                }
            }
            ans +=i-left+1;
        }
        return ans;
    }
}