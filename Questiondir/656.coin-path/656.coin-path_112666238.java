public class Solution {
    private static final int MAX_COST = 1000000;
    
    public List<Integer> cheapestJump(int[] A, int B) {
        final int N = A.length;
        if (A[N - 1] < 0) {
            return new ArrayList<Integer>();
        }
        int[] cost = new int[N];
        int[] next = new int[N];
        Arrays.fill(cost, MAX_COST);
        Arrays.fill(next, -1);
        cost[N - 1] = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= i - B && j >= 0; j--) {
                if (A[j] < 0) {
                    continue;
                }
                int newCost = cost[i] + A[j];
                if (newCost <= cost[j]) {
                    cost[j] = newCost;
                    next[j] = i;
                }
            }
        }
        int p = 0;
        List<Integer> path = new ArrayList<>();
        while (p >= 0) {
            path.add(p);
            p = next[p];
        }
        int sz = path.size();
        if (sz > 0 && path.get(sz - 1) == N - 1) {
            for (int i = 0; i < sz; i++) {
                path.set(i, 1 + path.get(i));
            }
            return path;
        } else {
            return new ArrayList<Integer>();
        }
        // Collections.reverse(path);
        // if (path.size() > 0 && path.get(0) == 0) {
        //     for (int i = 0; i < path.size(); i++) {
        //         path.set(i, 1 + path.get(i));
        //     }
        //     return path;
        // } else {
        //     return new ArrayList<Integer>();
        // }
    }
}