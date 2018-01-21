class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] edge : edges) {
            map.put(edge[0],edge[0]);
            map.put(edge[1],edge[1]);
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v= edge[1];
            int rootU = find(u, map);
            int rootV = find(v, map);
            if (rootU == rootV) return edge;
            map.put(rootV, rootU);
        }
        return edges[edges.length - 1];
    }
    
    
    private int find(int u, Map<Integer, Integer> map) {
        int root = map.get(u);
        if (u != root) {
            map.put(u, find(root, map));
        }
        return map.get(u);
    }
}