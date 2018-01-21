import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int answer = nums[0] * nums[1] * nums[2];
        answer = Math.max(answer, nums[0] * nums[1] * nums[nums.length - 1]);
        answer = Math.max(answer, nums[0] * nums[nums.length - 2] * nums[nums.length - 1]);
        answer = Math.max(answer, nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
        for (int num : nums) {
            if (num == 0) {
                answer = Math.max(answer, 0);
            }
        }
        return answer;
        
    }
}