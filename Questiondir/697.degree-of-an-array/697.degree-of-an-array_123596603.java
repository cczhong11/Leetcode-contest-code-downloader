class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!numsMap.containsKey(num)) {
                numsMap.put(num, 0);
                leftMap.put(num, i);
            }
            numsMap.put(num, numsMap.get(num) + 1);
            rightMap.put(num, i);
        }
        
        int degree = 0;
        for (Integer num : numsMap.keySet()) {
            degree = Math.max(degree, numsMap.get(num));
        }
        
        int ans = nums.length;
        for (Integer num : numsMap.keySet()) {
            if (numsMap.get(num) == degree) {
                ans = Math.min(ans, rightMap.get(num) - leftMap.get(num) + 1);
            }
        }
        
        return ans;
    }
}