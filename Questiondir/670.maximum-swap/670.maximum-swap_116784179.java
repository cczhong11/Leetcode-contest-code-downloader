import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int maximumSwap(int num) {
    	if (num == 0) return 0;
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
        	digits.add(num % 10);
        	num /= 10;
        }
        Collections.reverse(digits);
        int n = digits.size();
        for (int i = 0; i < n; ++i) {
        	int index = -1;
        	for (int j = i; j < n; ++j) {
        		if (index == -1 || digits.get(j) >= digits.get(index) ) {
        			index = j;
        		}
        	}
        	if (digits.get(i) == digits.get(index)) {
        		continue;
        	}
        	int tmp = digits.get(i);
        	digits.set(i, digits.get(index));
        	digits.set(index, tmp);
        	break;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
        	res = res * 10 + digits.get(i);
        }
        return res;
    }
}