class Solution {
    public int findLength(int[] A, int[] B) {
        int alen = A.length, blen = B.length, res = 0;
        for (int i = 0; i < alen - res; i++) {
            for (int j = 0; j < blen - res; j++) {
                if (A[i] == B[j]) {
                    int pA = i;
                    for (int pB = j; pA < alen && pB < blen; pA++, pB++)
                        if (A[pA] != B[pB]) break;
                    res = Math.max(res, pA - i);
                }
            }
        }
        return res;
    }
}