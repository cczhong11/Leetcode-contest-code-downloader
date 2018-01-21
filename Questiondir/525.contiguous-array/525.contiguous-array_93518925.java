public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                arr[i] = -1;
            }
            else {
                arr[i] = 1;
            }
        }
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (preSum.containsKey(sum)) {
                int start = preSum.get(sum);
                ans = Math.max(ans, i - start);
            }
            else {
                preSum.put(sum, i);
            }
        }
        return ans;
    }
}