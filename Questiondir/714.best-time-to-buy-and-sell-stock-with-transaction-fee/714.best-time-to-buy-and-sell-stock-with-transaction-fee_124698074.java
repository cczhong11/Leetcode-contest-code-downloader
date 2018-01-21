	class Solution {
	    public int maxProfit(int[] prices, int fee) {
	        int n = prices.length;
	        int[] h = {0, Integer.MIN_VALUE + 60000};
	        for(int i = 0;i < n;i++){
	        	int[] nh = new int[2];
	        	nh[0] = Math.max(h[0], h[1] + prices[i] - fee);
	        	nh[1] = Math.max(h[1], h[0] - prices[i]);
	        	h = nh;
	        }
	        return h[0];
	    }
	}	
