	public class Solution {
	    public String reverseStr(String s, int k) {
	        int n = s.length();
	        char[] t = s.toCharArray();
	        for(int i = 0;i < n;i += 2*k){
	        	int j = Math.min(i+k, n);
	        	for(int u = i, v = j-1;u < v;u++,v--){
	        		char d = t[u]; t[u] = t[v]; t[v] = d;
	        	}
	        }
	        return new String(t);
	    }
	}	
