class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
        	if (A[i] > i + 1 || A[i] < i - 1) {
        		return false;
        	}
        	if (A[i] == i + 1) {
        		if (A[i+1] != i) {
        			return false;
        		}
        	}
        	if (A[i] == i - 1) {
        		if (A[i-1] != i) {
        			return false;
        		}
        	}
        }
        return true;
    }
}