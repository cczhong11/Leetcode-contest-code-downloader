public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] dp = new int[nums.length+1];
        int max = 0;
        
        map.put(0, 0);
        for (int i=0, j=0; i<nums.length; i++) {
            j += (nums[i]<<1)-1;
            if (map.containsKey(j)) {
                int len = map.get(j);
                
                dp[i+1] = dp[len]+i-len+1;
                max = Math.max(max, dp[i+1]);
            }
            map.put(j, i+1);
        }
        return max;
    }
}