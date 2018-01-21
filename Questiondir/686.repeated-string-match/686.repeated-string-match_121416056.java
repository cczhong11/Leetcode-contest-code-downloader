class Solution {
private int check(String A , String B , int startIndex) {
		
		int pos1 = 0 , pos2 = startIndex , ans = 0;
		while (pos2 < B.length() && (A.charAt(pos1) == B.charAt(pos2))) {
			if (pos1 == 0) {
				ans ++;
			}
			pos1 = (pos1 + 1) % A.length();
			pos2 ++;
		}
		if (pos2 == B.length()) {
			return ans;
		} else {
			return - 1;
		}
		
	}
	
    public int repeatedStringMatch(String A, String B) {
       
    	int j , length1 = A.length() , length2 = B.length() , ans = - 1;
    	int temp = check(A , B , 0);
    	if (temp >= 0) {
    		if (temp < ans || ans < 0) {
    			ans = temp;
    		}
    	}
    	for (j = length1 - 1;j >= 0;j --) {
    		int pos1 = j , pos2 = 0;
    		while (pos1 < length1 && pos2 < length2 && (A.charAt(pos1) == B.charAt(pos2))) {
    			pos1 ++;
    			pos2 ++;
    		}
    		if (pos1 == length1) {
    			temp = check(A , B , pos2);
    			if (temp >= 0) {
    				temp ++;
    				if (temp < ans || ans < 0) {
    					ans = temp;
    				}
    			}
    		}
    	}
    	return ans;
    	
    }
}