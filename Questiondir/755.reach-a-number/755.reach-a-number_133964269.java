class Solution {
    public int reachNumber(int target) {
    		if (target == 0) return 0;
    		if (target < 0) {
    			target = -target;
    		}
    		
    		long n = target;
    		long ans = 0;
    		for (long i = 1; ; i++) {
    			long sum = (1 + i) * i / 2;
    			if (sum >= n && (sum - n) % 2 == 0) {
    				ans = i;
    				break;
    			}
    			
    		}
    		return (int) ans;
    }
}