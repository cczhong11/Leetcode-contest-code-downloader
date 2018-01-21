public class Solution {
public int triangleNumber(int[] nums) {
    	int maxl = 1001;
    	int[] lengCnt = new int[maxl];
    	int total = 0;
    	for (int n : nums) {
    		lengCnt[n]++;
    	}
    	// all sides are equal
    	for (int i = 1; i < maxl; i++) {
    		int cnt = lengCnt[i];
    		if (cnt >=3) {
    			total += cnt * (cnt - 1) * (cnt -2) / 6;
    		}
    	}
    	// two sides are equal
    	for (int i = 1; i < maxl; i++) {
    		int cnt = lengCnt[i];
    		int stage = 1;
    		if (cnt >=2) {
    			stage = cnt * (cnt - 1) / 2;
    		} else {
    			continue;
    		}
    		for (int j = 1; j < i * 2 && j < maxl; j++) {
    			if (j == i) {
    				continue;
    			}
    			total += stage * lengCnt[j];
    		}
    	}
    	// all sides not equal
    	for (int i = 1; i < maxl; i++) {
    		if (lengCnt[i] == 0) {
    			continue;
    		}
    		for (int j = i + 1; j < maxl; j++) {
        		if (lengCnt[j] == 0) {
        			continue;
        		}
    			for (int k = j + 1; k < maxl && k < i + j; k++) {
    				total += lengCnt[i] * lengCnt[j] * lengCnt[k];
    			}
    		}
    	}
    	return total;
    }
}