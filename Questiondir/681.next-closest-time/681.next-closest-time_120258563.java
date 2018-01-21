	class Solution {
	    public String nextClosestTime(String time) {
	    	int my = 
	    			Integer.parseInt(time.substring(0, 2)) * 60 + 
	    			Integer.parseInt(time.substring(3));
	    			
	    	int mind = 9999;
	    	String best = "~";
	        for(int i = 0;i < 5;i++){
	        	if(i == 2)continue;
	        	for(int j = 0;j < 5;j++){
		        	if(j == 2)continue;
		        	int h = (time.charAt(i)-'0')*10+time.charAt(j)-'0';
		        	if(h >= 24)continue;
	        		for(int k = 0;k < 5;k++){
        				if(k == 2)continue;
	        			for(int l = 0;l < 5;l++){
	        				if(l == 2)continue;
	    		        	int m = (time.charAt(k)-'0')*10+time.charAt(l)-'0';
	    		        	if(m >= 60)continue;
	    		        	int t = 60*h+m;
	    		        	int d = t - my;
	    		        	if(d <= 0)d += 1440;
	    		        	if(d < mind){
	    		        		mind = d;
	    		        		best = String.format("%02d:%02d", h, m);
	    		        	}
	        			}
	        		}
	        	}
	        }
	        return best;
	    }
	}	
