	public class Solution {
	    public int findIntegers(int num) {
	        char[] bn = Integer.toBinaryString(num).toCharArray();
	        int n = bn.length;
	        int z = 0, o = 0;
	        boolean e = true;
	        for(int i = 0;i < n;i++){
	        	int nz = o+z, no = z;
	        	if(i == 0){
	        	}else{
		        	if(e && bn[i] == '1'){
		        		nz++;
		        	}
		        	no++;
		        	if(bn[i] == '1' && bn[i] == bn[i-1]){
		        		e = false;
		        	}
	        	}
	        	
	        	z = nz; o = no;
	        }
	        int ret = z + o + 1;
	        if(e)ret++;
	        return ret;
	    }
	}	
