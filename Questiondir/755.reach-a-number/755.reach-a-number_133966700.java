class Solution {
    public int reachNumber(int target) {
     
    	target = Math.abs(target);
    	long x = (long) Math.sqrt(2 * target);
    	while (true) {
    		long value1 = (x + 1) * x / 2;
    		long value2 = target;
    		long sum = value1 + value2;
    		if (sum % 2 == 0) {
    			long a = sum / 2;
    			long b = value1 - a;
    			if (a >= 0 && b >= 0) {
    				return (int) x;
    			}
    		}
    		x ++;
    	}
    	
    }
    
}