	public class Solution {
	    public boolean canPlaceFlowers(int[] flowerbed, int n) {
	    	int m = flowerbed.length;
	    	int put = 0;
	        for(int i = 0;i < flowerbed.length;i++){
	        	if(flowerbed[i] == 0 && (i == m-1 || flowerbed[i+1] == 0)){
	        		flowerbed[i] = 1;
	        		put++;
	        		i++;
	        	}else if(flowerbed[i] == 1){
	        		i++;
	        	}
	        }
	        return put >= n;
	    }
	}	
