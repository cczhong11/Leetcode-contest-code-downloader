public class Solution {
	private Map<Integer, Integer> map = new HashMap<>();
	public int findIntegers(int num) {
		if (num < 3) {
	        return num+1;
	    }
		if (num <= 4) {
			return num;
		}
		if (map.containsKey(num)) {
			return map.get(num);
		}
		int res = 0;
		int v = smallerPowerOf2(num);
        if ( v* 2 == num) {
        	res = 1 + findIntegers(num-1);
        } else {
        	if (num >= v + v/2) {
			   res = findIntegers(v+v/2-1);
        	} else {
        		res = findIntegers(num - v) + findIntegers(v-1);
        	}
		}
        map.put(num, res);
		return res;
    }

	private static int smallerPowerOf2(int v) {
		v--;
		v |= v >> 1;
		v |= v >> 2;
		v |= v >> 4;
		v |= v >> 8;
		v |= v >> 16;
		v++;
		return v >> 1;
	}
}