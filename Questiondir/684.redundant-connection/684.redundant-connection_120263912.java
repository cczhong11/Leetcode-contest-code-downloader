class Solution {
    
    int[] root = new int[2005], rank = new int[2005];
    
    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < 2005; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) return edge;
        }
        return new int[]{0, 0};
    }
    
    boolean union(int i, int j) {
        int ri = find(i), rj = find(j);
        if (ri == rj) return true;
        if (rank[ri] >= rank[rj]) {
            root[rj] = ri;
            if (rank[ri] == rank[rj]) {
                rank[ri]++;
            }
        }
        else {
            root[ri] = rj;
        }
        return false;
    }
    
    int find(int i) {
        if (root[i] != i) {
            root[i] = find(root[i]);
        }
        return root[i];
    }
}