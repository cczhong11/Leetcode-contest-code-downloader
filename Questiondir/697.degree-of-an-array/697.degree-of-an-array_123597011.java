class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            counts.put(n, counts.getOrDefault(n, 0) + 1);
            maxFreq = Math.max(maxFreq, counts.get(n));
            if (!left.containsKey(n)) {
                left.put(n, i);
            }
        }
        
        int minLen = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (counts.getOrDefault(nums[i], 0) == maxFreq) {
                minLen = Math.min(minLen, i - left.get(nums[i]) + 1);
                counts.remove(nums[i]);
            }
        }
        return minLen;
    }
}