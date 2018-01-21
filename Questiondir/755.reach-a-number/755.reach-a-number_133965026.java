	class Solution {
	    public int reachNumber(int target) {
	    	int s = 0;
	        for(int i = 1;;i++){
	        	s += i;
	        	if(Math.abs(target) <= s && Math.abs(target) % 2 == s % 2){
	        		return i;
	        	}
	        }
	    }
	}	
