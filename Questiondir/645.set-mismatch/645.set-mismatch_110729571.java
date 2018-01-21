public class Solution {
    public int[] findErrorNums(int[] nums) {
        int rep = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                rep = nums[i];
            } else {
                set.add(nums[i]);
                sum += nums[i];
            }
        }
        return new int[]{rep, nums.length*(1+nums.length)/2-sum};
    }
}