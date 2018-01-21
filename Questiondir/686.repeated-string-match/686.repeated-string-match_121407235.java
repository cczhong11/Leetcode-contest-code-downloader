class Solution {
    public int repeatedStringMatch(String A, String B) {
    	if (B.length()==0)
    		return 0;
    	if (A.length()==0)
    		return -1;
    	int min = B.length()+3;
        for (int i=0;i<A.length();++i) {
        	int max = Math.min(B.length()+i, A.length());
        	if (A.substring(i, max).equals(B.substring(0,max-i))) {
        		if (max==B.length()+i) {
        			return 1;
        		}
        		int start = A.length()-i;
        		boolean b = true;
        		int k = 1;
        		while (start+A.length()<=B.length()) {
        			if (B.substring(start,start+A.length()).equals(A)){
        				start += A.length();
        				++k;
        			}else {
        				b = false;
        				break;
        			}
        		}
        		if (b) {
        			if (start == B.length()) {
        				min = Math.min(min, k);
        			}else {
        				k +=1;
        				if (B.substring(start,B.length()).equals(A.substring(0,B.length()-start))){
        					min = Math.min(min, k);
        				}
        			}
        		}
        	}
        }
        if (min == B.length()+3)
        	return -1;
        else
        	return min;
    }
}