public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        int[] ans = {-1, -1};
        for(int i = 1; i <= n; i++) {
            if(s.contains(nums[i-1])) ans[0] = nums[i-1];
            s.add(nums[i-1]);
        }
        for(int i = 1; i <= n; i++) {
            if(!s.contains(i)) ans[1] = i;
        }
        return ans;
    }
}