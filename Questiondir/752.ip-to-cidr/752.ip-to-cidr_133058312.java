class Solution {
	private int getValue(String ip) {
		
		int ans = 0;
		String[] strs = ip.split("[.]");
		for (String string : strs) {
			int temp = Integer.parseInt(string);
			ans = ans * 256 + temp;
		}
		return ans;
		
	}
	
	private String getString(int value , int bit) {
		
		StringBuilder builder = new StringBuilder();
		for (int i = 31;i >= 0;i -= 8) {
			int temp = 0;
			for (int j = i;j >= i - 7;j --) {
				if ((value & (1 << j)) != 0) {
					temp = temp * 2 + 1;
				} else {
					temp *= 2;
				}
			}
			if (builder.length() > 0) {
				builder.append(".");
			}
			builder.append(temp);
		}
		builder.append("/");
		builder.append(bit);
		return builder.toString();
		
	}
	
    public List<String> ipToCIDR(String ip, int range) {
        
    	int start = getValue(ip);
    	List<String> ans = new ArrayList<>();
    	for (int i = start;i <= start + range - 1;i ++) {
    		if ((i & (1 << 0)) != 0) {
    			ans.add(getString(i , 32));
    		} else {
    			int originI = i;
    			int j = 0;
    			while (j < 32 && (i & (1 << j)) == 0) {
    				j ++;
    			}
    			if (j == 32) {
    				j --;
    			}
    			while (j >= 0) {
    				int temp = i + (1 << j) - 1;
    				if (temp <= start + range - 1) {
    					i = temp;
    					break;
    				}
    				j --;
    			}
    			ans.add(getString(originI , 32 - j));
    		}
    	}
    	return ans;
    	
    }
}