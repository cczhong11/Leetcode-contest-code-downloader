class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0 || k == 1) {
            return 0;
        }
        int n = nums.length;
        int j = 0;
        int product = 1;
        int res = 0;
        for(int i = 0; i < n; i++) {
            product *= nums[i];
            while(product >= k){
                product /= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }
}