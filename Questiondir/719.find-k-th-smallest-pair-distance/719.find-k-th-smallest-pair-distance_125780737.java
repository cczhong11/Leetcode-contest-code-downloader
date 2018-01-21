class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for (int num: nums) max = Math.max(num, max);
        int[] dis = new int[max+1];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int d = Math.abs(nums[i]-nums[j]);
                dis[d]++;
            }
        }
        int total = 0;
        for (int i = 0; i <= max; i++) {
            total += dis[i];
            // System.out.println(total+" "+dis[i]);
            if (total >= k) {
                return i;
            }
        }
        return 0;
    }
}