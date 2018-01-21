	public class Solution {
	    public int findDerangement(int n) {
	        int mod = 1000000007;
	        if(n == 1)return 0;
	        if(n == 2)return 1;
	        long a = 0, b = 1;
	        for(int i = 3;i <= n;i++){
	        	long c = (b+a)*(i-1)%mod;
	        	a = b; b = c;
	        }
	        return (int)b;
	    }
	}	