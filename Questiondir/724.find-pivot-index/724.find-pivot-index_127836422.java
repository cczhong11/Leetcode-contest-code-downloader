class Solution {
    public int pivotIndex(int[] nums) {
        int[] acc = new int[nums.length + 2];
        for(int i = 0; i < nums.length; ++ i) {
            acc[i+1] = acc[i] + nums[i];
        }
        acc[nums.length + 1] = acc[nums.length];
        for(int i = 0; i < nums.length; ++ i) {
            if(acc[i] == acc[nums.length + 1] - acc[i+1]) {
                return i;
            }
        }
        return -1;
    }
}