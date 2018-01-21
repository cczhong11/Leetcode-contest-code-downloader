	class Solution {
	    public String makeLargestSpecial(String S) {
	        char[] s = S.toCharArray();
	        int n = s.length;
	        while(true){
	        	boolean ch = false;
		        outer:
		        for(int i = 0;i < n;i++){
		        	int h = 0;
		        	int sec = 0;
			        int[] sp = new int[2];
		        	for(int j = i;j < n;j++){
		        		if(s[j] == '1'){
		        			h++;
		        		}else{
		        			h--;
		        		}
		        		if(h == 0){
		        			sp[sec++] = j;
		        			if(sec == 2){
		        				// [i,j]
		        				String L = new String(s, i, sp[0]+1-i);
		        				String R = new String(s, sp[0]+1, sp[1]+1-(sp[0]+1));
		        				if((L+R).compareTo(R+L) < 0){
		        					int p = i;
		        					for(int k = sp[0]+1, l = 0;k < sp[1]+1;k++,l++){
		        						s[p++] = R.charAt(l);
		        					}
		        					for(int k = i, l = 0;k < sp[0]+1;k++,l++){
		        						s[p++] = L.charAt(l);
		        					}
		        					ch = true;
		        				}
		        				continue outer;
		        			}
		        		}
		        		if(h < 0)continue outer;
		        	}
		        }
	        	if(!ch)break;
	        }
	        return new String(s);
	    }
	}	
