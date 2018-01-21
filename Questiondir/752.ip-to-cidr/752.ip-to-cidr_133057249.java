	class Solution {
	    public List<String> ipToCIDR(String ip, int range) {
	        long x = 0;
	        String[] sp = ip.split("\\.");
	        for(String s : sp)x = x<<8|Long.parseLong(s);
	        long cur = x, rem = range;
	        List<String> list = new ArrayList<>();
	        while(rem > 0){
	        	long len = cur == 0 ? 1L<<32 : cur&-cur;
	        	while(len > rem){
	        		len /= 2;
	        	}
	        	list.add(ip(cur) + "/" + (32-Long.numberOfTrailingZeros(len)));
	        	cur += len;
	        	rem -= len;
	        }
	        return list;
	    }
	    
	    public String ip(long x)
	    {
	    	String ret = "";
	    	for(int i = 0;i < 4;i++){
	    		if(i > 0)ret = "." + ret;
	    		ret = (x&255) + ret;
	    		x >>>= 8;
	    	}
	    	return ret;
	    }
	}	
