public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}