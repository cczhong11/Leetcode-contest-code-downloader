class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> node = new HashSet<>();
        Integer[] root = new Integer[2001];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (root[u] != null && root[v] != null && find(root, u) == find(root, v)) {
                return edges[i];
            } else {
                if (root[u] == null) root[u] = u;
                if (root[v] == null) root[v] = v;
                int r = find(root, u);
                int rv = find(root, v);
                root[rv] = r;
            }
        }
        return edges[0];
    }
    private int find(Integer[] root, int u) {
        if (root[u] == u) return u;
        else return root[u] = find(root, root[u]);
    }
}