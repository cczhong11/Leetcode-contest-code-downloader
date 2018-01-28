class Solution {
	int N;
	int[] bit;
	
	void add(int x) {
		while (x <= N) {
			bit[x]++;
			x += x & -x;
		}
	}
	
	int sum(int x) {
		int res = 0;
		while (x > 0) {
			res += bit[x];
			x -= x & -x;
		}
		return res;
	}
	
    public boolean isIdealPermutation(int[] A) {
    	N = A.length;
        int local = 0;
        for (int i = 0; i + 1 < N; ++i) {
        	if (A[i] > A[i + 1]) {
        		++local;
        	}
        }
        bit = new int[N + 1];
        for (int i = N - 1; i > 0; --i) {
        	add(A[i] + 1);
        	local -= sum(A[i - 1] + 1);
        }
       // System.out.print(local);
        return local == 0;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] A = new int[]{1, 2, 0};
    	solution.isIdealPermutation(A);
    }
}