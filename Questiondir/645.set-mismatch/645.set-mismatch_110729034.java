public class Solution {
    public int[] findErrorNums(int[] nums) {
    	int n = nums.length;
    	int[] res = new int[2];
    	int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
        	count[nums[i]]++;
        	if (count[nums[i]] > 1) {
        		res[0] = nums[i];
        	}
        }
        for (int i = 1; i <= n; i++) {
        	if (count[i] == 0) {
        		res[1] = i;
        		break;
        	}
        }
        return res;
    }
}