class Solution {
	private int calcInversion(int[] A, int a, int b) {
		if (a >= b) {
			return 0;
		}
		int m = (a + b) / 2;
		int sum = calcInversion(A, a, m) + calcInversion(A, m + 1, b);
		
		int j = a;
		for (int i = m + 1; i <= b; i++) {
			while (j <= m && A[j] <= A[i]) {
				j++;
			}
			sum += (m + 1 - j);
		}
		Arrays.sort(A, a, b + 1);
		return sum;
	}

	public boolean isIdealPermutation(int[] A) {
		int n = A.length;
		int localCount = 0;
		int globalCount = 0;
		
		for (int i = 0; i < n - 1; i++) {
			if (A[i] > A[i + 1]) {
				localCount++;
			}
		}
		
		globalCount = calcInversion(A, 0, n - 1);
		

		return globalCount == localCount;
	}
}