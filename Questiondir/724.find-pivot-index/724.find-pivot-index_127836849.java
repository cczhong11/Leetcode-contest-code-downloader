class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0;i < nums.length;++i)
            sum += nums[i];
        int res = -1;
        int s = 0;
        for (int j = 0;j < nums.length;++j) {
            if (sum - s - nums[j] == s) {
                res = j;
                break;
            }
            s += nums[j];
        }
        return res;
    }
}