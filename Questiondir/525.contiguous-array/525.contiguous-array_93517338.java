public class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int prev = nums[0] == 0 ? -1 : 1;
        map.put(prev, 0);
        int maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = prev + (nums[i] == 0 ? -1 : 1);
            if(map.containsKey(cur)) {
                maxLen = Math.max(maxLen,i - map.get(cur));
            }
            if(!map.containsKey(cur)) {
                map.put(cur,i);
            }
            prev = cur;
        }
        return maxLen;
    }
}