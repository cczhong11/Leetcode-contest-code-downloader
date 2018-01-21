import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = bound(nums, nums[i] + nums[j]);
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
//                System.out.println("k = " + k);
                if (k > j) {
                    answer += k - j;
                }
            }
        }
        return answer;
    }

    private int bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().triangleNumber(new int[]{2, 2, 3, 4}));
    }
}