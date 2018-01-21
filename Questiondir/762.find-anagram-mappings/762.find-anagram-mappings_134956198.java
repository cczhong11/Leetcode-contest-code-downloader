class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int len = A.length;
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (B[j] == A[i]) {
					B[j] = -1;
					res[i] = j;
					break;
				}
			}
		}
		return res;
    }
}