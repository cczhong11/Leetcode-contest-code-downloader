class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = (int)(1e6);
        while(left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for(int i = 0, j = 0; i < nums.length; ++ i) {
                for(j = Math.max(j, i+1); j < nums.length && nums[i] + mid >= nums[j]; ++ j) ;
                count += j - i - 1;
            }
            if(count >= k) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}