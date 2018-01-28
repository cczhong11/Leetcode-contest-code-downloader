	class Solution {
	    public int numJewelsInStones(String J, String S) {
	    	int ct = 0;
	        for(char c : S.toCharArray()){
	        	if(J.indexOf(c) >= 0){
	        		ct++;
	        	}
	        }
	        return ct;
	    }
	}	
