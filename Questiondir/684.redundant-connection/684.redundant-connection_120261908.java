class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[2010];
        for (int i=0; i<parent.length; i++)
            parent[i] = i;
        
        for (int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if (find(x) == find(y))
                return edge;
            else
                parent[find(x)] = find(y);
        }
        
        return null;
    }
    
    private int find(int x){
        if (x!=parent[x]){
          parent[x] = find(parent[x]);  
        }
        return parent[x];
    }
}