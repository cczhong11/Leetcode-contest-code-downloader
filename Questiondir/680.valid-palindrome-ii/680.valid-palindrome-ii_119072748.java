	class Solution {
	    public boolean validPalindrome(String S) {
	        char[] s = S.toCharArray();
	        if(ispal(s))return true;
	        for(int i = 0, j = s.length-1;i < j;i++,j--){
	        	if(s[i] != s[j]){
	        		int n = s.length;
	        		{
		        		char[] t = (S.substring(0, i) + S.substring(i+1)).toCharArray();
		    	        if(ispal(t))return true;
	        		}
	        		{
		        		char[] t = (S.substring(0, j) + S.substring(j+1)).toCharArray();
		    	        if(ispal(t))return true;
	        		}
	        		return false;
	        	}
	        }
	        return false;
	    }
	    
		public boolean ispal(char[] a)
		{
			for(int i = 0, j = a.length-1;i < j;i++,j--){
				if(a[i] != a[j])return false;
			}
			return true;
		}

	}	
