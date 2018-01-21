	public class Solution {
	    public int newInteger(int n) {
	        long low = 0, high = 3000000000L;
	        while(high - low > 1){
	        	long h = high+low>>1;
	        	long num = h-countContainingDigit(Long.toString(h).toCharArray(), 9);
	        	if(num < n){
	        		low = h;
	        	}else{
	        		high = h;
	        	}
	        }
	        return (int)high;
	    }
	    
		public long countContainingDigit(char[] sup, int d)
		{
			int n = sup.length;
			long cont = 0, notc = 0;
			boolean edgec = false;
			for(int i = 0;i < n;i++){
				int c = sup[i]-'0';
				// propagate
				cont = cont * 10 + notc;
				notc = notc * 9;
				
				// head
				if(i > 0){
					if(d > 0){
						notc += 8;
						cont += 1;
					}else{
						notc += 9;
					}
				}else{
					notc += c-1;
					if(d > 0 && d < c){
						notc--;
						cont++;
					}
				}
				
				// edge
				if(i > 0){
					if(edgec){
						cont += c;
					}else{
						notc += c;
						if(d < c){
							notc--;
							cont++;
						}
					}
				}
				if(c == d)edgec = true;
			}
			if(edgec){
				cont++;
			}else{
				notc++;
			}
			return cont;
		}
	}	
