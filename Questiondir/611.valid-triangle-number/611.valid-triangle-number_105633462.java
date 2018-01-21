public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int total = 0;
        int second, third;
        for (int first = 0; first < nums.length - 2; first++) {
            second = first + 1;
            third = first + 2;
            while (third < nums.length) {
                while (second < third && nums[first] + nums[second] <= nums[third]) {
                    second++;
                }
                total += third - second;
                third++;
            }
        }
        
        return total;
    }
}