class Solution {
    public String nextClosestTime(String time) {
        boolean[] valid = new boolean[10];
        valid[ time.charAt(0) - '0'] = true;
        valid[ time.charAt(1) - '0'] = true;
        valid[ time.charAt(3) - '0'] = true;
        valid[ time.charAt(4) - '0'] = true;
        
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        
        for (int h = hour; h <= hour + 24; ++h) {
        	for (int m = 0; m < 60; ++m) {
        		if (h == hour && m <= minute) {
        			continue;
        		}
        		int hh = h % 24;
        		if (valid[hh / 10] && valid[hh % 10] && valid[m / 10] && valid[m % 10]) {
        			StringBuilder res = new StringBuilder();
        			if (hh < 10) res.append('0');
        			res.append(hh);
        			res.append(':');
        			if (m < 10) res.append('0');
        			res.append(m);
        			return res.toString();
        		}
        	}
        }
        return null;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextClosestTime("23:59"));
      }
}