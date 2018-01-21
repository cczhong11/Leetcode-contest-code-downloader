class Solution {
  public boolean hasAlternatingBits(int n) {
     
    	boolean flag = true;
    	int i = 31;
    	while ((n & (1 << i)) == 0) {
    		i --;
    	}
    	while (i >= 0) {
    		if (flag) {
    			if ((n & (1 << i)) == 0) {
    				return false;
    			}
    			flag = false;
    		} else {
    			if ((n & (1 << i)) != 0) {
    				return false;
    			}
    			flag = true;
    		}
    		i --;
    	}
    	return true;
    	
    }
}