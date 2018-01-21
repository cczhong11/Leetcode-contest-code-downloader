public class Solution {
	    public int triangleNumber(int[] nums) {
	        Arrays.sort(nums);
	        int ret = 0;
	        for(int i = 0;i < nums.length;i++){
	        	int k = 0;
	        	for(int j = i+1;j < nums.length;j++){
	        		while(k < i && nums[k] <= nums[j]-nums[i])k++;
	        		ret += i-k;
	        	}
	        }
	        return ret;
	    }
}