public class Solution {
   public int countArrangement(int N) {
        if (N < 0) {
            return 0;
        }
        return dfs(N,0,new HashSet<>());
    }

    public int dfs(int N, int index, HashSet<Integer> visited) {
        if (index == N) {
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= N; i++) {
            if( (i % (index + 1)) == 0 || ((index + 1) % i) == 0) {
                if(!visited.contains(i)) {
                    visited.add(i);
                    res += dfs(N, index + 1, visited);
                    visited.remove(i);
                }
            }
        }
        return res;
    }
}