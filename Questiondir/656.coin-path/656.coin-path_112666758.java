import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	static final int MAX = 1000000;
	
	int N, B;
	int[] cost;
	int[] A;
	
	int getCost(int index) {
		if (A[index] == -1) return MAX;
		if (cost[index] >= 0) return cost[index];
		if (index == N - 1) {
			return A[index];
		} else {
			int res = MAX;
			for (int d = 1; d <= B; ++d) {
				if (index + d < N && A[index + d] != -1) {
					res = Math.min(res, getCost(index + d));
				}
			}
			res += A[index];
			cost[index] = Math.min(res, MAX);
			return res;
		}
	}
	
	void doIt(List<Integer> res, int index) {
		res.add(index + 1);
        if (index < N - 1) {
            int p = -1;
            for (int i = index + 1; i <= index + B && i < N; ++i) {
                if (p == -1 || getCost(i) < getCost(p)) {
                    p = i;
                }
            }
            //if (p == -1) { System.out.println("error: " + index); return; }
            doIt(res, p);
        }
	}
	
    public List<Integer> cheapestJump(int[] A_, int B_) {
		A = A_;
		B = B_;
        N = A.length;
        cost = new int[N];
        Arrays.fill(cost, -1);
        if (getCost(0) >= MAX) return new LinkedList<Integer>();
        List<Integer> res = new LinkedList<Integer>();
        doIt(res, 0);
        return res;
    }
}