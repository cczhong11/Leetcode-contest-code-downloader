	class Solution {
	    public boolean checkPossibility(int[] a) {
			int l = 1;
			
			while(l < a.length && a[l-1] <= a[l])l++;
			int r = a.length-2;
			while(r >= 0 && a[r+1] >= a[r])r--;
			if(l > r){
				if(l-r == 1){
					if(
							l-1 >= 0 && l+1 < a.length && a[l-1] > a[l+1]
							&&
							r-1 >= 0 && r+1 < a.length && a[r-1] > a[r+1]
							
							)return false;
				}
				return true;
			}else{
				return false;
			}
	    }
	}	
