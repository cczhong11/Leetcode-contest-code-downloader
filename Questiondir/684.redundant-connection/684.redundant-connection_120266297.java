class Solution {
    int[] uf = new int[2001];
    private void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        uf[pu] = pv;
    }
    private int find(int u) {
        if (uf[u] != u) {
            uf[u] = find(uf[u]);
        }
        return uf[u];
    }
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < 2001; ++i) {
            uf[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (find(u) == find(v)) return edge;
            union(u, v);
        }
        return null;
    }
}