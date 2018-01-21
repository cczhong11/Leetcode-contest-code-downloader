class Solution {
 	int ans = 0;
	
    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i] / 10, nums[i] % 10);
        }
        dfs(0, 0, map, 0);
        return ans;
    }
    
    void dfs(int depth, int curValue, Map<Integer, Integer> map, int sum) {
    	int key = (depth + 1) * 10 + (curValue + 1);
    	int leftKey = (depth + 1 + 1) * 10 + (curValue * 2 + 1);
    	int rightKey = (depth + 1 + 1) * 10 + (curValue * 2 + 1 + 1);
    	
    	if (!map.containsKey(leftKey) && !map.containsKey(rightKey)) {
    		ans += sum + map.get(key);
    		return;
    	}
    	if (map.containsKey(leftKey)) {
    		dfs(depth + 1, curValue * 2, map, sum + map.get(key));
    	}
    	
    	if (map.containsKey(rightKey)) {
    		dfs(depth + 1, curValue * 2 + 1, map, sum + map.get(key));
    	}
    }
}