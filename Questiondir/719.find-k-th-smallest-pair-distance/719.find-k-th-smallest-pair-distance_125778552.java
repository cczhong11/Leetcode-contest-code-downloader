class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] count = new int[1000001];
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                count[Math.abs(nums[i] - nums[j])]++;
            }
        }
        for(int i = 0; i <= 1000000; i++) {
            if ((k -= count[i]) <= 0) {
                return i;
            }
        }
        return 0;
    }
}