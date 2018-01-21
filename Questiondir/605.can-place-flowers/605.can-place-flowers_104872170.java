public class Solution {

	private int get(int from , int to , int n) {
		
		int total = to - from + 1;
		if (from == 0 && to == n - 1) {
			return (total + 1) / 2;
		} else {
			if (from == 0) {
				return total / 2;
			} else if (to == n - 1) {
				return total / 2;
			} else {
				if (total % 2 == 1) {
					return total / 2;
				} else {
					return total / 2 - 1;
				}
			}
		}
		
	}

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	
    	int i , total = flowerbed.length , cnt = 0;
    	for (i = 0;i < total;i ++) {
    		if (flowerbed[i] == 0) {
    			int start = i , end = i;
    			while (i < total && flowerbed[i] == 0) {
    				end = i;
    				i ++;
    			}
    			cnt += get(start , end , total);
    		}
    	}
    	if (cnt >= n) {
    		return true;
    	} else {
    		return false;
    	}
        
    }

}