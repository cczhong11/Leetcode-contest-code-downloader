class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] arr = new int[1000000];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++)
                arr[Math.abs(nums[i] - nums[j])]++;
        }
        for (int i = 0; i < 1000000; i++) {
            if (k <= arr[i]) return i;
            k -= arr[i];
        }
        return 0;
    }
}