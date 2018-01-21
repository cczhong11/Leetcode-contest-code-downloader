class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int p = 0, r = 1000000;
        while (p < r) {
            int q = p+(r-p)/2;
            int cnt = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i]+q >= nums[nums.length-1]) {
                    cnt += nums.length-i-1;
                } else {
                    int j = i+1, jj = nums.length-1;
                    while (j < jj) {
                        int mid = j+(jj-j)/2;
                        if (nums[mid] > nums[i]+q) {
                            jj = mid;
                        } else {
                            j = mid+1;
                        }
                    }
                    cnt += (j-i-1);
                }
            }
            if (cnt >= k) {
                r = q;
            } else {
                p = q+1;
            }
        }
        return p;
    }
}