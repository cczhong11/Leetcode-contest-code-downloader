	class Solution {
		int[] f(String x)
		{
			int[] f = new int[26];
			x = x.toLowerCase();
			for(char c : x.toCharArray()){
				if(c >= 'a' && c <=  'z'){
					f[c-'a']++;
				}
			}
			return f;
		}
		
	    public String shortestCompletingWord(String licensePlate, String[] words) {
	    	int[] lf = f(licensePlate);
	    	String best = null;
	    	outer:
	    	for(String s : words){
	    		int[] f = f(s);
	    		for(int i = 0;i < 26;i++){
	    			if(f[i] < lf[i])continue outer;
	    		}
	    		if(best == null || s.length() < best.length()){
	    			best = s;
	    		}
	    	}
	    	return best;
	    }
	}	
