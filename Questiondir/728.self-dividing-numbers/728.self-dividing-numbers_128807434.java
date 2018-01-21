import java.util.LinkedList;
import java.util.List;

class Solution {
	
	boolean check(int x) {
		int value = x;
		while (x > 0) {
			int d = x % 10;
			if (d == 0 || value % d != 0) {
				return false;
			}
			x /= 10;
		}
		return true;
	}
	
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; ++i) {
        	if (check(i)) {
        		res.add(i);
        	}
        }
        return res;
    }
}