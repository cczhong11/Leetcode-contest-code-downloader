import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> pos = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();
        int maxCnt = 0;
        for (int i = 0; i < nums.length; ++i) {
        	int x = nums[i];
        	pos.put(x, i);
        	if (map.containsKey(x)) {
        		map.put(x, map.get(x) + 1);
        	} else {
        		map.put(x, 1);
        	}
        	maxCnt = Math.max(maxCnt, map.get(x));
        }
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
        	if (!set.contains(nums[i]) && map.get(nums[i]) == maxCnt) {
        		res = Math.min(res, pos.get(nums[i]) - i + 1);
        		set.add(nums[i]);
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,2,3,1};
    	Solution solution = new Solution();
    	System.out.println(solution.findShortestSubArray(nums));
    }
}