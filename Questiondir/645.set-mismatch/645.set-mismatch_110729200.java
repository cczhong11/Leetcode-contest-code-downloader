public class Solution {
	private int[] cnt = new int[100010];
	
    public int[] findErrorNums(int[] nums) {
     
    	int i , n = nums.length;
    	Arrays.fill(cnt , 0);
    	for (int value : nums) {
    		cnt[value] ++;
    	}
    	int ans1 = - 1 , ans2 = - 1;
    	for (i = 1;i <= n;i ++) {
    		if (cnt[i] == 2) {
    			ans1 = i;
    		} else if (cnt[i] == 0) {
    			ans2 = i;
    		}
    	}
    	return new int[] {ans1 , ans2};
    	
    }
	
}