class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> buf = new ArrayList<>();
        List<Integer> ans = new ArrayList<>(), res = new ArrayList<>();
        int n = positions.length;
        for(int i = 0; i < n; ++i) {
            buf.add(new int[]{positions[i][0], i+1});
            buf.add(new int[]{positions[i][0] + positions[i][1], -i-1});
        }
        boolean[][] adj = new boolean[n][n];
        Collections.sort(buf, (a,b)->(a[0] == b[0] ? a[1] - b[1]: (a[0] - b[0])));
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < buf.size(); ++i) {
            int[] curr = buf.get(i);
            if(curr[1] > 0) {
                for(int m: set) {
                    adj[m][curr[1]-1] = true;
                    adj[curr[1]-1][m] = true;
                }
                set.add(curr[1]-1);
            }
            else {
                set.remove(-curr[1]-1);
            }
        }
        for(int i = 0; i < n; ++i) {
            int pre = 0;
            for(int j = 0; j < i; ++j) {
                if(adj[i][j]) pre = Math.max(pre, ans.get(j));
            }
            ans.add(positions[i][1] + pre);
            res.add(Math.max(i == 0? 0: res.get(i-1), ans.get(i)));
        }
        return res;
    }
}