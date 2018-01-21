class Solution {
    public int deleteAndEarn(int[] nums) {
        
        // sort the array first
        // if first two elements are not consecutive, then remove the first
        // if first two are consecutive, then at least one of them should be removed
        Arrays.sort(nums);
        return dp(nums, 0, new Integer[nums.length]);
        
    }
    
    private int dp(int[] nums, int start, Integer[] cache){
        
        int n = nums.length;
        if (start == n) return 0;
        
        if (cache[start] == null) {
            
            // find the first two element
            int ptr = start;
            while (ptr < n && nums[ptr] == nums[start]) ++ptr;
            
            int count1 = ptr - start;
            
            int end = ptr;
            while (end < n && nums[end] == nums[start]+1) ++end;
            
            int tmp1 = count1*nums[start]+dp(nums, end, cache); // simply remove the first 
            int tmp2 = dp(nums, ptr, cache); // do not remove first (remove second)
            
            cache[start] = Math.max(tmp1, tmp2);
            
        }
        
        return cache[start];
        
    }
}