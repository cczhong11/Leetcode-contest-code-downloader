class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();
        Map<Integer, Integer> maxMap = new HashMap<>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            cntMap.put(d, cntMap.getOrDefault(d, 0) + 1);

            max = Math.max(cntMap.get(d), max);

            if (!minMap.containsKey(d)) {
                minMap.put(d, i);
            }
            maxMap.put(d, i);
        }

        int ans = Integer.MAX_VALUE;
        for (int d : cntMap.keySet()) {
            if (cntMap.get(d) == max) {
                ans = Math.min(ans, maxMap.get(d) - minMap.get(d) + 1);
            }
        }

        return ans;
    }
}