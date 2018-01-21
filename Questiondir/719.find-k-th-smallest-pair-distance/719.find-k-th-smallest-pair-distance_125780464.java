class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] count = new int[1000000];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count[Math.abs(nums[i] - nums[j])]++;
            }
        }
        for (int i = 0; i < 1000000; i++) {
            if (count[i] >= k) {
                return i;
            } else {
                k -= count[i];
            }
        }
        return 0;
    }
}