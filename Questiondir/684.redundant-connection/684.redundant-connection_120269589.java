class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[2001];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (roots[u] == 0) {
                roots[u] = u;
            }
            if (roots[v] == 0) {
                roots[v] = v;
            }
            int rootU = findRoot(roots, u);
            int rootV = findRoot(roots, v);
            if (rootU == rootV) {
                return edges[i];
            } else {
                roots[rootV] = rootU;
            }
        }
        return new int[]{-1, -1};
    }
    
    private int findRoot(int[] roots, int id) {
        while (roots[id] != id) {
            id = roots[id];
        }
        return id;
    }
}