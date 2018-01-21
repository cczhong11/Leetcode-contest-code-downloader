public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int lo = j + 1, hi = nums.length - 1;
                while (lo + 1 < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[mid] >= nums[i] + nums[j]) {
                        hi = mid;
                    } else {
                        lo = mid;
                    }
                }
                
                if (nums[hi] < nums[i] + nums[j]) {
                    if (nums[i] + nums[j] > nums[hi]) {
                        count += hi - j;
                    }
                } else {
                    if (nums[i] + nums[j] > nums[lo]) {
                        count += lo - j;
                    }
                }
            }
        }
        return count;
    }
}