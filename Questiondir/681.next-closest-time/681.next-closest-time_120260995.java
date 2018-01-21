class Solution {
   private int toInteger(String t) {
    	return Integer.valueOf(t.split(":")[0]) * 60 + Integer.valueOf(t.split(":")[1]);
    }
    
    private int diff(String t0, String t1) {
    	int ti0 = toInteger(t0);
    	int ti1 = toInteger(t1);
    	if (ti1 <= ti0) {
    		ti1 += 24 * 60;
    	}
    	return ti1 - ti0;
    }
    public String nextClosestTime(String time) {
        String[] digits = {time.charAt(0) + "",
        		time.charAt(1) + "",
        		time.charAt(3) + "",
        		time.charAt(4) + ""};
        
        int diff = Integer.MAX_VALUE;
        String ans = time;
        
        for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < 4; j++) {
        		for (int k = 0; k < 4; k++) {
        			for (int l = 0; l < 4; l++) {
        				String t = digits[i] + digits[j] + ":" + digits[k] + digits[l];
        				
        				int a = Integer.valueOf(t.split(":")[0]);
        				int b = Integer.valueOf(t.split(":")[1]);
        				if (!(a >= 0 && a < 24 && b >= 0 && b < 60)) {
        					continue;
        				}
        				int d = diff(time, t);
        				if (diff > d) {
        					diff = d;
        					ans = t;
        				}
        			}
        		}
        	}
        }
        return ans;
    }
}