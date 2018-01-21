class Solution {
    public boolean checkPossibility(int[] nums) {
        int pos = -1;
        int n = 0;
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i] < nums[i - 1]) {
               pos = i;
               n++;
           }
        }
        if (n >= 2) return false;
        if (pos == -1) return true;
        if (pos < 2 || nums[pos] >= nums[pos - 2]) return true;
        if (pos == nums.length - 1 || nums[pos + 1] >= nums[pos - 1]) return true;
        return false;
    }
}