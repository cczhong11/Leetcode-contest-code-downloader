public class Solution {
    public int triangleNumber(int[] nums) {
        int re = 0;
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int first = 0;
        while(first < nums.length && nums[first] == 0) first++;
        while(first < nums.length - 2) {
            int second = first + 1;
            int third = second + 1;
            while(second < nums.length) {
                while(third <= second || (third < nums.length && nums[third] < nums[first] + nums[second])) third++;
                re += (third - second - 1);
                second++;
            }
            first++;
        }
        return re;
    }
}