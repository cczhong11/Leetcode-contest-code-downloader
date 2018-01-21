public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int c1 = nums[0]*nums[1]*nums[nums.length-1]; // 2 neg + 1 pos
        int c2 = nums[n-1]*nums[n-2]*nums[n-3]; // 3 pos
        return Math.max(c1,c2);
    }
}