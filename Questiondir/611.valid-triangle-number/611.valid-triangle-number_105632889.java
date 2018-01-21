public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lower = j + 1;
                int higher = nums.length - 1;
                if (lower > higher) {
                    continue;
                }
                int max= nums[i] + nums[j] - 1;
                int min = Math.abs(nums[i] - nums[j]) + 1;
                int l = findMin(nums, lower, higher, min);
                int r = findMax(nums, lower, higher, max);
                if (l <= r) {
                    counter += r - l + 1;
                }
            }
        }
        return counter;
    }
    public int findMin(int[] nums, int lower, int higher, int min) {
        if (nums[higher] < min) {
            return nums.length;
        }
        while (lower + 1 < higher) {
            int mid = (lower + higher) / 2;
            if (nums[mid] >= min) {
                higher = mid;
            }
            else {
                lower = mid;
            }
        }
        if (nums[lower] >= min) {
            return lower;
        }
        return higher;
    }
    public int findMax(int[] nums, int lower, int higher, int max) {
        if (nums[lower] > max) {
            return -1;
        }
        while (lower + 1 < higher) {
            int mid = (lower + higher) / 2;
            if (nums[mid] <= max) {
                lower = mid;
            }
            else {
                higher = mid;
            }
        }
        if (nums[higher] <= max) {
            return higher;
        }
        return lower;
    }
}