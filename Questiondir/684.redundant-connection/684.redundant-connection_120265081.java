class Solution {
    private int index;
    private Map<Integer, Integer> indexer;

    public int[] findRedundantConnection(int[][] edges) {
        indexer = new HashMap<>();
        index = 0;
        int n = edges.length;
        UnionFind uf = new UnionFind(1001);
        for (int[] e : edges) {
            int u = getIndex(e[0]), v = getIndex(e[1]);
            if (uf.isUnion(u, v)) {
                return e;
            }
            uf.union(u, v);
        }
        return null;
    }
    
    private int getIndex(int id) {
        if (indexer.containsKey(id)) {
            return indexer.get(id);
        } else {
            indexer.put(id, index);
            return index++;
        }
    }
    
    private static class UnionFind {
        int[] id;
        int[] sz;
        UnionFind(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++)
                id[i] = i;
            sz = new int[n];
            Arrays.fill(sz, 1);
        }
        
        int root(int i) {
            while (id[i] != i) {
                i = id[i] = id[id[i]];
            }
            return i;
        }
        
        boolean isUnion(int i, int j) {
            return root(i) == root(j);
        }
        
        void union(int i, int j) {
            i = root(i);
            j = root(j);
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    }
}