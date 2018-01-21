	class Solution {
	    public int flipLights(int n, int m) {
	        n = Math.min(n, 20);
	        int mask = (1<<n)-1;
	        int u = 0;
	        for(int t = 0;t < n;t+=3){
	        	u |= 1<<t;
	        }
	        Set<Integer> set = new HashSet<>();
	        for(int i = 0;i < 1<<4;i++){
	        	if(Integer.bitCount(i) <= m && Integer.bitCount(i) % 2 == m % 2){
	        		int x = 0;
	        		if(i<<~0<0){
	        			x ^= mask;
	        		}
	        		if(i<<~1<0){
	        			x ^= mask&0x55555555;
	        		}
	        		if(i<<~2<0){
	        			x ^= mask&0xaaaaaaaa;
	        		}
	        		if(i<<~3<0){
	        			x ^= u;
	        		}
	        		set.add(x);
	        	}
	        }
	        return set.size();
	    }
	}	
