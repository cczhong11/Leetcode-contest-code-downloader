	public class Solution {
	    public boolean judgeCircle(String moves) {
	    	int[] f = new int[128];
	    	for(char c : moves.toCharArray()){
	    		f[c]++;
	    	}
	    	return f['U'] == f['D'] && f['L'] == f['R'];
	    }
	}	
