class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind();
        for(int[] e : edges) {
            if(!uf.union(e[0], e[1])) {
                return e;
            }
        }
        return new int[2];
    }
    
    private class UnionFind {
        Map<Integer, Integer> map;
        UnionFind() {
            map = new HashMap<>();
        }
        
        int find(int a) {
            int root = a;
            if(!map.containsKey(root)) {
                map.put(root, root);
                return root;
            }
            while(root != map.get(root)) {
                root = map.get(root);
            }
            return root;
        }
        
        boolean union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if(roota == rootb) {
                return false;
            }
            map.put(rootb, roota);
            return true;
        }
    }
}