import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
    	int N = A.length;
        Set<Integer> set = new HashSet<Integer>();
        int[] P = new int[N];
        for (int i = 0; i < N; ++i) {
        	for (int j = 0; j < N; ++j) {
        		if (A[i] == B[j] && !set.contains(j)) {
        			P[i] = j;
        			set.add(j);
                    break;
        		}
        	}
        }
        return P;
    }
}