class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, s = 0, e = nums[n-1] - nums[0], m;
        while(s<e) {
            m = (s+e)/2;
            int j = 0, count = 0;
            for(int i = 0; i < n; ++i) {
                while(j < n && (j == i || nums[j] - nums[i] <= m)) ++j;
                count += j - i - 1;
            }
            if(count < k) s = m+1;
            else e = m;
        }
        return s;
    }
}