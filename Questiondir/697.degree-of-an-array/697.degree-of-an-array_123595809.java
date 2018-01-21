class Solution {
  public int findShortestSubArray(int[] nums) {
    int[] cnt = new int[50000];
    int[] first = new int[50000];
    int[] last = new int[50000];
    Arrays.fill(first, -1);
    for (int i = 0; i < nums.length; ++i) {
      int num = nums[i];
      ++cnt[num];
      if (first[num] == -1) {
        first[num] = i;
      }
      last[num] = i;
    }
    int maxF = 0;
    for (int i = 0; i < 50000; ++i) {
      maxF = Math.max(maxF, cnt[i]);
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < 50000; ++i) {
      if (cnt[i] == maxF) {
        res = Math.min(res, last[i] - first[i] + 1);
      }
    }
    return res;
  }
}