class Solution {
   public String makeLargestSpecial(String S) {
     
    	int i , j , length = S.length();
    	while (true) {
    		String result = null;
    		for (i = 0;i < length;i ++) {
	    		int cnt = 0;
	    		for (j = i;j < length;j ++) {
	    			if (S.charAt(j) == '1') {
	    				cnt ++;
	    			} else {
	    				 if (cnt > 0) {
	    					 cnt --;
	    				 } else {
	    					 break;
	    				 }
	    			}
	    			if (cnt == 0) {
		    			// from i to j
		    			int temp = 0;
		    			for (int pos = j + 1;pos < length;pos ++) {
		    				if (S.charAt(pos) == '1') {
		    					temp ++;
		    				} else {
		    					if (temp > 0) {
		    						temp --;
		    					} else {
		    						break;
		    					}
		    				}
		    				if (temp == 0) {
		    					// from j + 1 to pos
		    					StringBuilder builder = new StringBuilder();
		    					builder.append(S.substring(0 , i));
		    					builder.append(S.substring(j + 1 , pos + 1));
		    					builder.append(S.substring(i , j + 1));
		    					builder.append(S.substring(pos + 1));
		    					String s = builder.toString();
		    					if (result == null || s.compareTo(result) > 0) {
		    						result = s;
		    					}
		    				}
		    			}
	    			}
	    		}
	    	}
	    	if (result == null) {
	    		break;
	    	} else {
	    		if (result.compareTo(S) > 0) {
	    			S = result;
	    		} else {
	    			break;
	    		}
	    	}
    	}
    	return S;
    	
    }
}