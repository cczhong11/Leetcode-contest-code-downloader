class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] diffFreq = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                diffFreq[Math.abs(nums[i] - nums[j])]++;
            }
        }
        for (int diff = 0; diff < diffFreq.length; diff++) {
            if (diffFreq[diff] >= k) return diff;
            k -= diffFreq[diff];
        }
        return 0;
    }
}