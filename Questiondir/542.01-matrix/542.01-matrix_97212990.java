public class Solution {
    private int[] dir = { 0, -1, 0, 1, 0 };
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) return matrix;
        int m = matrix.size(), n = matrix.get(0).size();
        
        List<List<Integer>> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>(Collections.nCopies(n, -1)));
        }
        
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> curr = matrix.get(i);
            for (int j = 0; j < n; j++) {
                if (curr.get(j) == 0) {
                    res.get(i).set(j, 0);
                    que.add(new int[] { i, j });
                }
            }
        }
        
        int dist = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] curr = que.remove();
                int i = curr[0], j = curr[1];
                
                for (int d = 0; d < 4; d++) {
                    int di = i + dir[d], dj = j + dir[d+1];
                    if (0 <= di && di < m && 0 <= dj && dj < n && res.get(di).get(dj) == -1) {
                        res.get(di).set(dj, dist);
                        que.add(new int[] { di, dj });
                    }
                }
            }
            dist++;
        }
        
        return res;
    }
}