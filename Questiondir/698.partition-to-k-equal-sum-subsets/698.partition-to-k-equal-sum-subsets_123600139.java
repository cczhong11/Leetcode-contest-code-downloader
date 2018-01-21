class Solution {
  int[] sum;
  boolean[] valid;

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int totalSum = 0;
    for (int num : nums) totalSum += num;
    if (totalSum % k > 0) return false;
    int partSum = totalSum / k;
    int n = nums.length;
    sum = new int[1 << n];
    for (int mask = 1; mask < 1 << n; ++mask) {
      sum[mask] = sum[mask ^ Integer.lowestOneBit(mask)] + nums[Integer.numberOfTrailingZeros(mask)];
    }
    valid = new boolean[1 << n];
    valid[(1 << n) - 1] = true;
    for (int mask = (1 << n) - 1; mask > 0; --mask) if (valid[mask]) {
      for (int subMask = mask; subMask >= 0; subMask = (subMask - 1) & mask) {
        if (subMask == 0) break;
        if (sum[subMask] == partSum) {
          valid[mask ^ subMask] = true;
        }
      }
    }
    return valid[0];
  }
}