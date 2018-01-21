public class Solution {
    public int newInteger(int n) {
     
    	int ans = 0;
    	StringBuilder builder = new StringBuilder();
    	while (n > 0) {
    		builder.append(n % 9);
    		n /= 9;
    	}
    	builder.reverse();
    	for (int i = 0;i < builder.length();i ++) {
    		ans = ans * 10 + (builder.charAt(i) - '0');
    	}
    	return ans;
    	
    }
}