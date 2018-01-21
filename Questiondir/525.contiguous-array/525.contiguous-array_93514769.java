public class Solution {

	private Map<Integer , Integer> map = new HashMap<Integer , Integer>();
	
    public int findMaxLength(int[] nums) {
    	
    	if (nums.length == 0)
    		return 0;
    	
    	int i , n = nums.length , cnt0 = 0 , cnt1 = 0 , ans = 0;
    	for (i = 0;i < n;i ++) {
    		if (nums[i] == 0) {
    			cnt0 ++;
    		} else {
    			cnt1 ++;
    		}
    		int value = cnt0 - cnt1;
    		if (value == 0) {
    			if (i + 1 > ans)
    				ans = i + 1;
    		} else {
    			if (map.containsKey(value)) {
    				int temp = (i - map.get(value));
    				if (temp > ans)
    					ans = temp;
    			} else
    				map.put(value , i);
    		}
    	}
    	return ans;
        
    }

}