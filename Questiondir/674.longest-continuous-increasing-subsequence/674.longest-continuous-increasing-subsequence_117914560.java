class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] array = new int[n];
        int len = 0;
        int ans = 0;
  
        for (int i = 0; i < n; ) {
        	int j = i;
        	while (j + 1 < n && nums[j + 1] > nums[j]) {
        		j++;
        	}
        	ans = Math.max(ans, j - i + 1);
        	i = j + 1;
        }
        return ans;
    }
}