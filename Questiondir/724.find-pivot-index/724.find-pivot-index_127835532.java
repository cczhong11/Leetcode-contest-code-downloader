import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur * 2 + nums[i] == sum) {
                return i;
            }
            cur += nums[i];
        }
        return -1;
                
    }
}