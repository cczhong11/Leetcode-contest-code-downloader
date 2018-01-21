	class Solution {
	    public int repeatedStringMatch(String A, String B) {
	        StringBuilder sb = new StringBuilder();
	        int rep = 0;
	        while(sb.length() < B.length()){
	        	sb.append(A);
	        	rep++;
	        }
	        if(sb.toString().indexOf(B) >= 0){
	        	return rep;
	        }
	        sb.append(A);
	        rep++;
	        if(sb.toString().indexOf(B) >= 0){
	        	return rep;
	        }
	        return -1;
	    }
	}
