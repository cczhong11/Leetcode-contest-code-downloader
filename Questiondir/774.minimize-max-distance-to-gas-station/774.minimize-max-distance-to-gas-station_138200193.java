class Solution {
    public boolean isIdealPermutation(int[] A) {
        int i = 0;
        while (i < A.length - 1) {
            if (A[i] == i) {
                ++i;
                continue;
            }
            if (A[i] == i + 1) {
                if (A[i + 1] == i) {
                    i += 2;
                    continue;
                } else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }
}