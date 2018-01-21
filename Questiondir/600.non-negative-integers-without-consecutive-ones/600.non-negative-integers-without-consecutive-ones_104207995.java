public class Solution {
    public int findIntegers(int num) {
    	int total = getTotal(num);
    	int[] bits = toBit(num);
    	int start = 0;
    	for(int i = 0; i < bits.length; i ++) {
    		if(bits[i] == 0 && bits[i - 1] != 1) total -= calculateNums(bits.length - i - 2);
    		if(i > 0 && bits[i] == bits[i - 1] && bits[i] == 1) break;
    	}
    	return total;
    }
    
    

	private int[] toBit(int num) {
		int counter = 0;
		int bit = 1;
		for(int i = 0; i < 32; i ++) {
			if((num & bit) != 0) counter = i + 1;
			bit = bit << 1;
		}
    	int[] bits = new int[counter];
    	bit = 1;
    	for(int i = 0; i < counter; i ++) {
    		bits[counter - 1 - i] = ((bit & num) == 0 ? 0 : 1);
    		bit = bit << 1;
    	}
    	return bits;
    }

	private int getTotal(int num) {
		int counter = 0;
		int bit = 1;
		for(int i = 0; i < 32; i ++) {
			if((num & bit) != 0) counter = i + 1;
			bit = bit << 1;
		}
		return calculateNums(counter);
	}
	
	private int calculateNums(int length) {
		if(length <= 0) return 1;
		int[][] dp = new int[length][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		for(int i = 1;  i < length; i ++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}
		return dp[length - 1][0] + dp[length - 1][1];	
	}
}